package bg.marto.softuni_mobilelele.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Brand extends BaseEntity {

    private String name;
    private List<Model> model;

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    public List<Model> getModel() {
        return model;
    }

    public Brand setModel(List<Model> model) {
        this.model = model;
        return this;
    }
}
