package railRoadElements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "RailroadSwitch"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class RailroadSwitch extends RailRoadElement {
    @XmlElement
    private int Z = Constants.Z;
    @XmlElement
    private double X;
    @XmlElement
    private double Y;

    public void initRailroadSwitch(String id, String name, double x, double y) {
        setId(id);
        setName(name);
        setX(x);
        setY(y);
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }
}
