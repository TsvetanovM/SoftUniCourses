package ReflectionAndAnnotations.BarracksWars.Core.Commands;

import ReflectionAndAnnotations.BarracksWars.Annotations.Inject;
import ReflectionAndAnnotations.BarracksWars.Interfaces.Repository;

public class Report extends Command{
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
