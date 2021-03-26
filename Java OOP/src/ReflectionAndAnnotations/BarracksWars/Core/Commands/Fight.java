package ReflectionAndAnnotations.BarracksWars.Core.Commands;

public class Fight extends Command{


    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
