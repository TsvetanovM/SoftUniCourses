package LoggingServce.Model.Appenders;

import LoggingServce.API.Appender;
import LoggingServce.API.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    protected Layout getLayout() {
        return layout;
    }

    @Override
    public void appendMessage(String datetime, String reportLevel, String message) {

    }
}
