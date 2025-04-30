package smb.socialnetwork.demo.controller;

import smb.socialnetwork.demo.service.PostService;

public class PostCommand implements Command {

    private final PostService postService;
    private final String username;
    private final String message;

    public PostCommand(PostService postService, String username, String message) {
        this.postService = postService;
        this.username = username;
        this.message = message;
    }

    @Override
    public void execute() {
        postService.postMessage(username, message);
    }
}
