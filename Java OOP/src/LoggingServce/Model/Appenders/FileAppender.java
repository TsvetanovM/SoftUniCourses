package LoggingServce.Model.Appenders;

import LoggingServce.API.File;
import LoggingServce.API.Layout;
import LoggingServce.Enums.ReportLevel;
import LoggingServce.Model.Files.LogFile;

public class FileAppender extends Appender{
    private File file;

    protected FileAppender(Layout layout) {
        super(layout);
        setFile(new LogFile());
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void appendMessage(String datetime, ReportLevel reportLevel, String message) {

    }
}
