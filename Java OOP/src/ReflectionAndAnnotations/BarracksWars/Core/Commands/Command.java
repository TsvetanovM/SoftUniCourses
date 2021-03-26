package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Interfaces.Executable;

public abstract class Command implements Executable {

    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}