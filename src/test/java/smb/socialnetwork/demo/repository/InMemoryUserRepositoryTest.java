package smb.socialnetwork.demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smb.socialnetwork.demo.model.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUserRepositoryTest {

    private InMemoryUserRepository inMemoryUserRepository;

    @BeforeEach
    void setup() {
        inMemoryUserRepository = new InMemoryUserRepository();
    }

    @Test
    public void findByUsernameTest() {
        User user = new User("username");
        inMemoryUserRepository.save(user);
        Optional<User> inMemoryUser = inMemoryUserRepository.findByUsername("username");
        assertNotNull(inMemoryUser);
        assertTrue(inMemoryUser.isPresent());
        assertEquals("username", inMemoryUser.get().getUsername());
    }

    @Test
    public void nonExistingUserTest() {
        Optional<User> inMemoryUser = inMemoryUserRepository.findByUsername("username");
        assertTrue(inMemoryUser.isEmpty());
    }

}
