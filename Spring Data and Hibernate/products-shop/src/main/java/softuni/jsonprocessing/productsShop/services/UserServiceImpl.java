package softuni.jsonprocessing.productsShop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.jsonprocessing.productsShop.models.dtos.UserSeed;
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
        validateUsersAndPersist(userSeeds);
    }

    private void validateUsersAndPersist(UserSeed[] userSeeds) {
        for (UserSeed userSeed : userSeeds) {
            Set<ConstraintViolation<UserSeed>> violations = validationUtil.getViolations(userSeed);

            if (!violations.isEmpty()) {
                violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
                continue;
            }

            User map = mapper.map(userSeed, User.class);
            userRepository.save(map);
        }
    }

}
