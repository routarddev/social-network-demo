package smb.socialnetwork.demo.service;

import org.springframework.stereotype.Service;
import smb.socialnetwork.demo.model.User;
import smb.socialnetwork.demo.repository.UserRepository;

import static smb.socialnetwork.demo.util.Constants.USER_NOT_FOUND_MSG;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createOrGetUser(String username) {
        return userRepository.findByUsername(username)
                .orElseGet(() -> {
                    User newUser = new User(username);
                    userRepository.save(newUser);
                    return newUser;
                });
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    // TODO: review
    public void follow(String followerUsername, String followedUsername) {
        User follower = createOrGetUser(followerUsername);
        User followed = createOrGetUser(followedUsername);
        follower.addFollowed(followed);
        userRepository.save(follower);
    }

    // TODO: review
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND_MSG + username));
    }

}
