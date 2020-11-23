# CustomRecyclerAdapter
A generic adapter for recyclerview, forget about creating an adapter for each recyclerview in your application.

This library works with androidx and databinding.

# Installation
**Step 1.** Add the JitPack repository to your build file. Add it in your project's build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Enable databinding in your app's module build.gradle
```gradle
android {
	...
	buildFeatures {
        dataBinding = true
	...
    }
}
```
**Step 3.** Add the dependency in your app's module build.gradle
```gradle
dependencies {
    implementation "com.github.gmlocarlos:Custom-Recycler-Adapter:1.0.0"
}
```

# Usage
**Step 1.** Create the layout for the recyclerview items
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="8dp">
    <TextView
        android:id="@+id/tvName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
    <TextView
        android:id="@+id/tvAge"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"/>
</RelativeLayout>
</layout>
```
**Step 2.** Create the model that will represent each item in the recyclerview
```java
public class User {
    private int userId;
    private String name;
    private int age;

    public User(int userId,String name, int age){
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // this method is only for this example
    public static List<User> getSampleUsers(){
        List<User> listSample = new ArrayList<>();
        listSample.add(new User(1,"Juan Perez",18));
        listSample.add(new User(2,"Carlos Sarmiento",32));
        return listSample;
    }
}
```
**Step 3.** In your activity or fragment, create an instance of CustomRecyclerAdapter taking into account the previously created layout and model
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        CustomRecyclerAdapter<User, ItemRecyclerBinding> recyclerAdapter = new CustomRecyclerAdapter<User, ItemRecyclerBinding>() {
            @Override
            protected void onBindData(User user, int i, ItemRecyclerBinding itemRecyclerBinding) {
                itemRecyclerBinding.tvName.setText(user.getName());
                itemRecyclerBinding.tvAge.setText(String.valueOf(user.getAge()));
            }
            @Override
            protected int getLayoutResId() {
                return R.layout.item_recycler;
            }
            @Override
            protected void onItemClick(User user, int i) {
                Toast.makeText(MainActivity.this,"row clicked",Toast.LENGTH_LONG).show();
            }
        };
        recyclerAdapter.setList(User.getSampleUsers());
        binding.recyclerView.setAdapter(recyclerAdapter);
    }
```
