package smb.socialnetwork.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import smb.socialnetwork.demo.model.User;
import smb.socialnetwork.demo.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User alice;
    private User bob;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        alice = new User("Alice");
        bob = new User("Bob");
    }

    @Test
    public void followUserTest() {
        when(userRepository.findByUsername("Bob")).thenReturn(Optional.ofNullable(bob));
        when(userRepository.findByUsername("Alice")).thenReturn(Optional.ofNullable(alice));
        userService.follow(bob.getUsername(), alice.getUsername());
    }
}
