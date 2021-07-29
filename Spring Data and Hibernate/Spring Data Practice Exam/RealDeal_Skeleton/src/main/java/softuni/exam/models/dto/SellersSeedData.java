package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellersSeedData {

    @XmlElement(name = "seller")
    private List<SellerSeedData> sellers;

    public List<SellerSeedData> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerSeedData> sellers) {
        this.sellers = sellers;
    }
}
