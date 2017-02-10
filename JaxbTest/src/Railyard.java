import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Railyard")
@XmlAccessorType(XmlAccessType.FIELD)
public class Railyard extends RailRoadElement{
    @XmlElement(name = "Shapes")
    private Shapes shapes;

    public void initRailyard(String railyardId, String railyardName, int railyardX, int railyardY, Shapes railyardShapes) {
        setId(railyardId);
        setName(railyardName);
        setX(railyardX);
        setY(railyardY);
        setShapes(railyardShapes);
    }

    public void setShapes(Shapes shapes) {
        this.shapes = shapes;
    }
}
