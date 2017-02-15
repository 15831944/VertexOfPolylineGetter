package railRoadElements;

import railRoadElements.RailRoadElement;
import railRoadElements.Shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "Railyard"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Railyard extends RailRoadElement {
    @XmlElement(
            name = "Shapes"
    )
    private Shapes shapes;


    public void initRailyard(String railyardId, String railyardName, int railyardX, int railyardY, Shapes railyardShapes) {
        this.setId(railyardId);
        this.setName(railyardName);
        this.setX(railyardX);
        this.setY(railyardY);
        this.setShapes(railyardShapes);
    }

    public void setShapes(Shapes shapes) {
        this.shapes = shapes;
    }
}