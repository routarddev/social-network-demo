package smb.socialnetwork.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Autowired
    private User user;

    @Test
    void userCreationTest() {
        User user = new User("username");
        user.addPost(new Post("username", "test message"));
        assertNotNull(user);
        assertEquals("test message", user.getTimeline().get(0).getMessage());
    }

    @Test
    void followerUserTest() {
        User max = new User("Max");
        max.addPost(new Post("Max", "Max post"));
        User charlie = new User("Charlie");
        charlie.addPost(new Post("Charlie", "Charlie test"));
        max.addFollowed(charlie);
        assertNotNull(max);
        assertNotNull(max.getListOfFollowedUsers());
        assertNotNull(max.getListOfFollowedUsers().get(0));
        assertEquals("Charlie", max.getListOfFollowedUsers().get(0).getUsername());
    }

}
