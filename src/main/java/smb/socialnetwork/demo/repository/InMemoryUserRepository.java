package smb.socialnetwork.demo.repository;

import smb.socialnetwork.demo.model.User;

import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
