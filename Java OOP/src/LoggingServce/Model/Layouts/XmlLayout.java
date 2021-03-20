package LoggingServce.Model.Layouts;

import LoggingServce.API.Layout;

public class XmlLayout implements Layout {


    @Override
    public String getLayout() {
        return "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>";
    }
}
