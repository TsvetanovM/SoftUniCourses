package bg.softuni.gamestore.models.dto;


public class UserRegisterAdmin extends UserRegister {

    private final boolean isAdmin;

    public UserRegisterAdmin(String email, String password, String confirmPassword, String fullName) {
        super(email, password, confirmPassword, fullName);
        isAdmin = true;
    }

    public UserRegisterAdmin(){
        isAdmin = true;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
