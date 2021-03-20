package LoggingServce;

import LoggingServce.API.Appender;
import LoggingServce.API.Layout;
import LoggingServce.API.Logger;
import LoggingServce.Model.Appenders.ConsoleAppender;
import LoggingServce.Model.Layouts.XmlLayout;
import LoggingServce.Model.Loggers.MessageLogger;

public class Main {
    public static void main(String[] args) {
        Layout xmlLayout = new XmlLayout();
        Appender consoleAppender = new ConsoleAppender(xmlLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");

    }
}
