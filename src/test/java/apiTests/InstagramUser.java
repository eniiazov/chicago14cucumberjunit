package apiTests;

import java.util.List;

public class InstagramUser {

    String name;
    String username;
    int age;
    List<Post> posts;
    int numOfPosts;

    public InstagramUser(String name, int age, String username){
        this.name = name;
        this.age = age;
        this.username = username;
    }

}
