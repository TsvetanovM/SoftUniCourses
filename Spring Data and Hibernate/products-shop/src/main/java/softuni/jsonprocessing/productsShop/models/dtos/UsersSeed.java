package softuni.jsonprocessing.productsShop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSeed {

    @XmlElement(name = "user")
    private List<UserSeed> users = null;

    public List<UserSeed> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeed> users) {
        this.users = users;
    }
}
