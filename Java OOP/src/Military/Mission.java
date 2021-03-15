package Military;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", getCodeName(), getState());
    }
}
