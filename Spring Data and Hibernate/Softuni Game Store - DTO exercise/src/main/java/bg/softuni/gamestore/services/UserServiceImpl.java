package bg.softuni.gamestore.services;

import bg.softuni.gamestore.models.dto.UserRegister;
import bg.softuni.gamestore.models.dto.UserRegisterAdmin;
import bg.softuni.gamestore.models.entities.User;
import bg.softuni.gamestore.repositories.UserRepository;
import bg.softuni.gamestore.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validation;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validation) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validation = validation;
    }

    @Override
    public void registerUser(UserRegister userRegister) {
        if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
            System.out.println("Passwords do not match!");
            return;
        }
            Set<ConstraintViolation<UserRegister>> violations = this.validation.violation(userRegister);
            if (!violations.isEmpty()) {
                violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                return;
            }

        if (userRepository.count() == 0) {
            var userAdmin = mapper.map(userRegister, UserRegisterAdmin.class);
            userRepository.save(mapper.map(userAdmin, User.class));
            return;
        }

        userRepository.save(mapper.map(userRegister, User.class));
    }
}
