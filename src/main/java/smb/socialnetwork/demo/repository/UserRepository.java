package smb.socialnetwork.demo.repository;

import smb.socialnetwork.demo.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByUsername(String username);
}
