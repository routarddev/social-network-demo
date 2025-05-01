package smb.socialnetwork.demo.util;

import smb.socialnetwork.demo.controller.*;
import smb.socialnetwork.demo.service.PostService;
import smb.socialnetwork.demo.service.UserService;

import static smb.socialnetwork.demo.util.Constants.*;
import static smb.socialnetwork.demo.util.Constants.WALL;

public class CommandParser {

    public static Command parse(String input, UserService userService, PostService postService) {

        if(input.contains(POSTING)) {
            String[] parts = input.split(POSTING);
            String username = parts[0].trim();
            String message = parts[1].trim();
            return new PostCommand(postService, username, message);

        } else if(input.contains(FOLLOW)) {
            String[] parts = input.split(FOLLOW);
            String follower = parts[0].trim();
            String followed = parts[1].trim();
            return new FollowCommand(userService, follower, followed);

        } else if(input.endsWith(WALL)) {
            String username = input.split(WALL)[0].trim();
            return new WallCommand(userService, username, System.out::println);

        } else if(!input.isEmpty()) {
            return new ReadCommand(userService, input.trim(), System.out::println);
        }

        return null;
    }
}
