package com.gmlo.libraryproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.gmlo.cra.CustomRecyclerAdapter;
import com.gmlo.libraryproject.databinding.ActivityMainBinding;
import com.gmlo.libraryproject.databinding.ItemRecyclerBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        CustomRecyclerAdapter<User, ItemRecyclerBinding> recyclerAdapter = new com.gmlo.cra.CustomRecyclerAdapter<User, ItemRecyclerBinding>() {
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
}