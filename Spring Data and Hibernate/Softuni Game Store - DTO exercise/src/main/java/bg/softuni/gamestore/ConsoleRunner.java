package bg.softuni.gamestore;

import bg.softuni.gamestore.models.dto.UserLogin;
import bg.softuni.gamestore.models.dto.UserRegister;
import bg.softuni.gamestore.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner;
    private final UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
//        Enter 0 as input to exit the program
        while (true) {
            System.out.print("Please enter the desired action: ");
            String[] input = scanner.nextLine().split("\\|");
            String action = input[0];
            switch (action) {
                case "0" -> {
                    return;
                }
                case "RegisterUser" -> userService
                        .registerUser(new UserRegister(input[1], input[2], input[3], input[4]));

                case "LoginUser" -> userService.loginUser(new UserLogin(input[1], input[2]));



                default -> System.out.println("Please enter the input in a valid format!");
            }
        }
    }
}
