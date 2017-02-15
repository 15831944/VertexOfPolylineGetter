package railRoadElements;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.dom4j.DocumentHelper;

import javax.xml.bind.annotation.XmlElement;

public class RailRoadElement {
    @XmlElement
    private String Id;
    @XmlElement
    private String Name;
    @XmlElement
    private int X;
    @XmlElement
    private int Y;
    @XmlElement
    private Label Label = new Label();
    @XmlElement
    private boolean PublicFlag = Constants.PUBLIC_FLAG;
    @XmlElement
    private boolean PresentationFlag = Constants.PRESENTATION_FLAG;
    @XmlElement
    private boolean ShowLabel = Constants.SHOW_LABEL;
    @XmlElement
    private String DrawMode = Constants.DRAW_MODE;

    public RailRoadElement() {
    }

    public void setId(String id) {
        this.Id = id;
    }

    @XmlCDATA
    public void setName(String name) {
        this.Name = DocumentHelper.createCDATA(name).asXML();
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }
}