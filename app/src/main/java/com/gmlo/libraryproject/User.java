package com.gmlo.libraryproject;
import java.util.ArrayList;
import java.util.List;

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