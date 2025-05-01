package smb.socialnetwork.demo.controller;

import smb.socialnetwork.demo.model.Post;
import smb.socialnetwork.demo.model.User;
import smb.socialnetwork.demo.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

import static smb.socialnetwork.demo.util.Constants.DATETIME_FORMAT;

public class ReadCommand implements Command {

    private final UserService userService;
    private final String username;
    private final Consumer<String> output;

    public ReadCommand(UserService userService, String username, Consumer<String> output) {
        this.userService = userService;
        this.username = username;
        this.output = output;
    }

    /*
        TODO: Not printing message but call the corresponding application or return it.
         Change void to return CommandResult and then do something with it!
        TODO: Use getUser instead and handle not existing users
     */
    @Override
    public void execute() {
        User user = userService.createOrGetUser(username);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);

        if (user != null) {
            for(Post post: user.getTimeline()) {
                String line = String.format("%s (%s)",
                        post.getMessage(),
                        post.getTimestamp().format(formatter));
                output.accept(line);
            }
        }

    }

}
