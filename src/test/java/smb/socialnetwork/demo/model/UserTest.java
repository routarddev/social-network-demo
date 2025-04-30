package smb.socialnetwork.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Autowired
    private User user;

    @Test
    void userCreationTest() {
        User user = new User("username");
        assertNotNull(user);
    }

    @Test
    void followerUserTest() {

    }

}
