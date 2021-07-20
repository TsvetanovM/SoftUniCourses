package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.UserRegister;

public interface UserService {

    void registerUser(UserRegister userRegister);
}
