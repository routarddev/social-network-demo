package smb.socialnetwork.demo.model;

import java.time.LocalDateTime;

public class Post {

    private final String username;
    private final String message;
    private final LocalDateTime timestamp;

    public Post(String username, String message) {
        this.username = username;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
