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
}
