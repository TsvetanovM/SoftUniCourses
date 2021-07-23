package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;

public interface UserService {

    void seedUsers(UserSeed[] userSeeds);

    boolean userTableIsEmpty();
}
