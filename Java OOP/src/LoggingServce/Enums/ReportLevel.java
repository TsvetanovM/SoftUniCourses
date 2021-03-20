package LoggingServce.Enums;

public enum ReportLevel {
    INFO(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4),
    FATAL(5);

    private int importanceLevel;

    ReportLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public int getImportanceLevel() {
        return importanceLevel;
    }
}
