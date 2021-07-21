package bg.softuni.gamestore;

import bg.softuni.gamestore.models.dto.GameAdd;
import bg.softuni.gamestore.models.dto.UserLogin;
import bg.softuni.gamestore.models.dto.UserRegister;
import bg.softuni.gamestore.services.GameService;
import bg.softuni.gamestore.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private final Scanner scanner;
    private final UserService userService;
    private final GameService gameService;

    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
//        Enter "Exit" as input to exit the program
        while (true) {
            System.out.print("Please enter the desired action: ");
            String[] input = scanner.nextLine().split("\\|");
            String action = input[0];
            switch (action) {
                case "Exit" -> {
                    return;
                }
                case "RegisterUser" -> userService
                        .registerUser(new UserRegister(input[1], input[2], input[3], input[4]));

                case "LoginUser" -> userService.loginUser(new UserLogin(input[1], input[2]));

                case "Logout" -> userService.logout();

                case "AddGame" -> gameService.addGame(createGameAdd(input));

                default -> System.out.println("Please enter the input in a valid format!");
            }
        }
    }

    private GameAdd createGameAdd(String[] input) {
        return new GameAdd(input[1], new BigDecimal(input[2]), Long.parseLong(input[3]),
                input[4], input[5], input[6], LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
