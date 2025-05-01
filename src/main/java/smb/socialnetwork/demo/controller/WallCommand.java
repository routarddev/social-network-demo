package smb.socialnetwork.demo.controller;

import smb.socialnetwork.demo.model.Post;
import smb.socialnetwork.demo.model.User;
import smb.socialnetwork.demo.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static smb.socialnetwork.demo.util.Constants.DATETIME_FORMAT;

public class WallCommand implements Command {

    private final UserService userService;
    private final String username;
    private final Consumer<String> output;

    public WallCommand(UserService userService, String username, Consumer<String> output) {
        this.userService = userService;
        this.username = username;
        this.output = output;
    }

    @Override
    public void execute() {
        try {
            User user = userService.getUser(username);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

            List<Post> wallPosts = new ArrayList<>();
            wallPosts.addAll(user.getTimeline());

            for (User follows : user.getListOfFollowedUsers()) {
                wallPosts.addAll(follows.getTimeline());
            }

            wallPosts.sort(Comparator.comparing(Post::getTimestamp).reversed());

        /*
            TODO: No printing in the command.
            TODO: Use getUser instead and handle not existing users
        */
            for (Post post : wallPosts) {
                String wallLine = String.format("%s - %s (%s)",
                        post.getUsername(),
                        post.getMessage(),
                        post.getTimestamp().format(formatter));

                output.accept(wallLine);
            }

        } catch(RuntimeException e) {
            output.accept(e.getMessage());
        }
    }

}
