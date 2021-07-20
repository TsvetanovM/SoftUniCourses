package bg.softuni.gamestore.services;

public interface UserService {
    void registerUser(String email, String password, String confirmPassowrd, String fullName);
}
