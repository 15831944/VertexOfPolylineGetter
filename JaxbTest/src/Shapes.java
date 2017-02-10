import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Shapes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shapes {
    @XmlElement(name = "Railyard")
    private Railyard railyard;
    @XmlElement(name = "RailTrack")
    private RailTrack railTrack;

    public void setRailyard(Railyard railyard) {
        this.railyard = railyard;
    }

    public void setRailTrack(RailTrack railTrack) {
        this.railTrack = railTrack;
    }
}
