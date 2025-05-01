# social-network-demo

## Social Network Demo Project

<small>@author: Sandra Marcos Bonet</small>

The exercise consists of implementing a console-based social networking application satisfying the scenarios below:

*Posting*: Anyone can publish messages on their personal timeline:

```
> Alice -> I love the weather today
> Bob -> Damn! We lost!
> Bob -> Good game though.
```

*Reading*: Anyone can view anyone’s timeline

```
> Alice
I love the weather today (5 minutes ago)
> Bob
Good game though. (1 minute ago)
Damn! We lost! (2 minutes ago)
```

*Following*: Anyone can subscribe to anyone’s timelines, and view an aggregated list of all subscriptions.

```
> Charlie -> I'm in New York today! Anyone want to have a coffee?
> Charlie follows Alice
> Charlie wall
Charlie - I'm in New York today! Anyone want to have a coffee? (2
seconds ago)
Alice - I love the weather today (5 minutes ago)
> Charlie follows Bob
> Charlie wall
Charlie - I'm in New York today! Anyone wants to have a coffee?
(15 seconds ago)
Bob - Good game though. (1 minute ago)
Bob - Damn! We lost! (2 minutes ago)
Alice - I love the weather today (5 minutes ago)
```

Details:
- The application must use the console for input and output.
- Users submit commands to the application.
- Commands always start with the user’s name.
- There are four types commands:
    - posting: user name -> message
    - reading: user name
    - following: user name follows another user
    - wall: user name wall


<br/>

### Comments

- Development has followed an iterative approach, beginning with the project skeleton and progressing through the model,
    the repository (data management), business logic, and I/O interaction layers.
- Test-Driven Development (TDD) was applied in the initial commits, following the cycle of writing a test, 
    watching it fail, and then implementing the necessary classes or methods to make it pass.
- The implementation emphasizes separation of concerns and follows a layered architecture.

Tasks:
- [x] Tests written for: `User`, `UserService`, and `UserRepository`
- [ ] To do: Write tests for `Post`, `PostRepository`, `PostService`, Commands, and `CommandParser`