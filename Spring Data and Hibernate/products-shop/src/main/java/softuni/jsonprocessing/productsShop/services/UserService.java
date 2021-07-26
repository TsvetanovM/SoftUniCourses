package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;

public interface UserService {

    boolean userTableIsEmpty();

    void seedUsers(UserSeed[] userSeeds);
}
