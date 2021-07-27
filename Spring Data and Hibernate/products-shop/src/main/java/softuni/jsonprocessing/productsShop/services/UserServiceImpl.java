package softuni.jsonprocessing.productsShop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;
import softuni.jsonprocessing.productsShop.models.dtos.UsersSeed;
import softuni.jsonprocessing.productsShop.models.entities.User;
import softuni.jsonprocessing.productsShop.repositories.UserRepository;
import softuni.jsonprocessing.productsShop.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, @Qualifier("General") ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean userTableIsEmpty() {
        return userRepository.count() == 0;
    }

    @Override
    public void seedUsers(UserSeed[] userSeeds) {
        for (UserSeed userSeed : userSeeds) {
            validateAndMapToEntity(userSeed);
        }
    }

    @Override
    public void seedUsers(UsersSeed usersSeed) {
        for (UserSeed userSeed : usersSeed.getUsers())  {
            validateAndMapToEntity(userSeed);
        }
    }

    private void validateAndMapToEntity(UserSeed userSeed) {
        Set<ConstraintViolation<UserSeed>> violations = validationUtil.getViolations(userSeed);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        User map = mapper.map(userSeed, User.class);
        userRepository.save(map);
    }

}
