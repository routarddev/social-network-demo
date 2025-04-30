package smb.socialnetwork.demo.controller;

import smb.socialnetwork.demo.service.UserService;

public class FollowCommand implements Command {
    private final UserService userService;
    private final String follower;
    private final String followed;

    public FollowCommand(UserService userService, String follower, String followed) {
        this.userService = userService;
        this.follower = follower;
        this.followed = followed;
    }
    @Override
    public void execute() {
        userService.follow(follower, followed);
    }
}
