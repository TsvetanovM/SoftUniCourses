package softuni.jsonprocessing.productsShop.services;

import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;
import softuni.jsonprocessing.productsShop.models.dtos.UsersSeed;
import softuni.jsonprocessing.productsShop.models.dtos.UsersWithSoldProducts;

import java.util.List;

public interface UserService {

    boolean userTableIsEmpty();

    void seedUsers(UserSeed[] userSeeds);

    void seedUsers(UsersSeed usersSeed);

    UsersWithSoldProducts getAllUsersWhoHaveSoldAnItem();

}
