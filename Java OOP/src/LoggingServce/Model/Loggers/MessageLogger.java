package LoggingServce.Model.Loggers;

import LoggingServce.API.Appender;
import LoggingServce.API.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new Appender[appenders.length];
        System.arraycopy(appenders, 0, this.appenders, 0, appenders.length);
    }

    @Override
    public void logInfo(String dateTime, String message) {
        callAppenders(dateTime, "Info", message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        callAppenders(dateTime, "Warning", message);
    }

    @Override
    public void logError(String dateTime, String message) {
        callAppenders(dateTime, "Error", message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        callAppenders(dateTime, "Critical", message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        callAppenders(dateTime, "Fatal", message);
    }

    private void callAppenders(String dateTime, String reportLevel, String message) {
        Arrays.stream(appenders).forEach(a -> a.appendMessage(dateTime, reportLevel, message));
    }
}
