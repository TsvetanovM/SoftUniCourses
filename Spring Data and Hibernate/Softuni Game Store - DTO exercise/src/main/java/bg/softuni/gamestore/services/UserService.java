package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.UserLogin;
import bg.softuni.gamestore.models.dto.UserRegister;

public interface UserService {

    void registerUser(UserRegister userRegister);

    void loginUser(UserLogin userLogin);

    void logout();
}
