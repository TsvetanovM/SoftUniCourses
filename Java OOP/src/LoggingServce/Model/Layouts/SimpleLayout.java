package LoggingServce.Model.Layouts;

import LoggingServce.API.Layout;

public class SimpleLayout implements Layout {


    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
