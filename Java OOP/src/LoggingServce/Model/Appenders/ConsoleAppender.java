package LoggingServce.Model.Appenders;

import LoggingServce.API.Layout;
import LoggingServce.Enums.ReportLevel;

public class ConsoleAppender extends Appender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(String datetime, ReportLevel reportLevel, String message) {
        if (assessReportLevel(reportLevel)) {
            System.out.println(String.format(super.getLayout().getLayout(), datetime, reportLevel.name(), message));
        }
    }

    private boolean assessReportLevel(ReportLevel reportLevel) {
       return reportLevel.getImportanceLevel() >= getReportLevel().getImportanceLevel();
    }
}
