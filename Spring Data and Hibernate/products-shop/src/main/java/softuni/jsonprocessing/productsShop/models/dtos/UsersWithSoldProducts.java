package softuni.jsonprocessing.productsShop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProducts {

    @XmlElement(name = "user")
    private List<UserWithSoldProducts> users;

    public List<UserWithSoldProducts> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProducts> users) {
        this.users = users;
    }
}
