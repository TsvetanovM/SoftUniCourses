package Military;

import java.util.LinkedHashSet;
import java.util.Set;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    public void addPrivate(PrivateImpl priv) {
        privates.add(priv);
    }

    @Override
    public Set<PrivateImpl> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString() + System.lineSeparator());
        output.append("Privates:").append(System.lineSeparator());
        getPrivates().stream().sorted((p1, p2) -> Integer.compare(p2.getId(), p1.getId()))
                .forEach(p -> output.append("  ").append(p.toString()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
