package Military;

public class SpyImpl extends SoliderImpl implements Spy{
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Code Number: " + getCodeNumber();
    }
}
