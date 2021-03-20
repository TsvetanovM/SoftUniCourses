package LoggingServce.Model.Loggers;

import LoggingServce.API.Logger;
import LoggingServce.Enums.ReportLevel;
import LoggingServce.Model.Appenders.Appender;

import java.util.Arrays;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new Appender[appenders.length];
        System.arraycopy(appenders, 0, this.appenders, 0, appenders.length);
    }

    @Override
    public void logInfo(String dateTime, String message) {
        callAppenders(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        callAppenders(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        callAppenders(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        callAppenders(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        callAppenders(dateTime, ReportLevel.FATAL, message);
    }

    private void callAppenders(String dateTime, ReportLevel reportLevel, String message) {
        Arrays.stream(appenders).forEach(a -> a.appendMessage(dateTime, reportLevel, message));
    }
}
