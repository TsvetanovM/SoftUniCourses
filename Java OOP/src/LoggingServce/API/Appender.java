package LoggingServce.API;

public interface Appender {
    void appendMessage(String datetime, String reportLevel, String message);
}
