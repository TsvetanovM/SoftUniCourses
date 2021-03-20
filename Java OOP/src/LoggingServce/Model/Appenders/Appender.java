package LoggingServce.Model.Appenders;

import LoggingServce.API.Layout;
import LoggingServce.Enums.ReportLevel;

public abstract class Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    protected Appender(Layout layout) {
        this.layout = layout;
    }

    protected Layout getLayout() {
        return layout;
    }

    protected ReportLevel getReportLevel() {
        return reportLevel;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public abstract void appendMessage(String datetime, ReportLevel reportLevel, String message);
}
