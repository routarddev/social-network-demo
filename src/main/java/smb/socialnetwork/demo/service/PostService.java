package smb.socialnetwork.demo.service;

import org.springframework.stereotype.Service;
import smb.socialnetwork.demo.model.Post;
import smb.socialnetwork.demo.model.User;

@Service
public class PostService {

    private final UserService userService;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public void postMessage(String username, String message) {
        User user = userService.createOrGetUser(username);
        user.addPost(new Post(username, message));
        userService.saveUser(user);
    }
}
