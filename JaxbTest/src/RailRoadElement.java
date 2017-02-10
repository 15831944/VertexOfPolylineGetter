import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.dom4j.DocumentHelper;

public class RailRoadElement {
    private String Id;
    private String Name;
    private int X;
    private int Y;
    private Label Label = new Label();
    private boolean PublicFlag = Constants.PUBLIC_FLAG;
    private boolean PresentationFlag = Constants.PRESENTATION_FLAG;
    private boolean ShowLabel = Constants.SHOW_LABEL;
    private String DrawMode = Constants.DRAW_MODE;

    public void setId(String id) {
        Id = id;
    }

    // replace?
    @XmlCDATA
    public void setName(String name) {
        Name = DocumentHelper.createCDATA(name).asXML();
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setLabel(int x, int y) {
        Label = new Label();
        Label.setX(x);
        Label.setY(y);
    }
}
