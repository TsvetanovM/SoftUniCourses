package softuni.jsonprocessing.productsShop.services;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
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
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(UserSeed[] userSeeds) {
        for (UserSeed userSeed : userSeeds) {
            Set<ConstraintViolation<UserSeed>> violations = validationUtil.getViolations(userSeed);

            if (!violations.isEmpty()) {
                violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
                continue;
            }

            User user = mapper.map(userSeed, User.class);
            userRepository.save(user);
        }
    }

    @Override
    public boolean userTableIsEmpty() {
        return userRepository.count() == 0;
    }
}
