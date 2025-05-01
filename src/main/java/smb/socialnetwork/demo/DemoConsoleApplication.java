package smb.socialnetwork.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import smb.socialnetwork.demo.controller.Command;
import smb.socialnetwork.demo.service.PostService;
import smb.socialnetwork.demo.service.UserService;
import smb.socialnetwork.demo.util.CommandParser;

import java.util.Scanner;

import static smb.socialnetwork.demo.util.Constants.UNKNOWN_CMD_MSG;

@SpringBootApplication
public class DemoConsoleApplication implements CommandLineRunner {

	private final UserService userService;
	private final PostService postService;

	public DemoConsoleApplication(UserService userService, PostService postService) {
		this.userService = userService;
		this.postService = postService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Console-based social networking");
		System.out.println("Commands:");
		System.out.println("To post: <username> -> <message>");
		System.out.println("To read: <username>");
		System.out.println("To follow: <username> follows <another username>");
		System.out.println("To view the wall: <username> wall");
		System.out.println("Type 'exit' to quit\n");

		while(true) {
			String input = scanner.nextLine().trim();

			if(input.equalsIgnoreCase("exit")) {
				break;
			}

			Command command = CommandParser.parse(input, userService, postService);
			if(command != null) {
				command.execute();
			} else {
				System.out.println(UNKNOWN_CMD_MSG);
			}
		}

	}
}
