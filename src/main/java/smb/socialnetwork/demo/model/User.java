package smb.socialnetwork.demo.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private final List<Post> timeline = new ArrayList<>();
    private final List<User> listOfFollowedUsers = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void addFollowed(User user) {
        listOfFollowedUsers.add(user);
    }

    public List<Post> getTimeline() {
        return this.timeline;
    }

    public List<User> getListOfFollowedUsers() {
        return this.listOfFollowedUsers;
    }

    public void addPost(Post post) {
        timeline.add(post);
    }

}
