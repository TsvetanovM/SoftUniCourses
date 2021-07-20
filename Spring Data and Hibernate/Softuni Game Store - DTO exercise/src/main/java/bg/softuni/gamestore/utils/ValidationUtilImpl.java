package bg.softuni.gamestore.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtilImpl implements ValidationUtil {

   private final Validator validator;

   public ValidationUtilImpl() {
      this.validator = Validation.buildDefaultValidatorFactory().getValidator();
   }

   @Override
   public <E> boolean isValid(E entity) {
      return this.validator.validate(entity).isEmpty();
   }

   @Override
   public <E> Set<ConstraintViolation<E>> violation(E entity) {
      return this.validator.validate(entity);
   }
}
