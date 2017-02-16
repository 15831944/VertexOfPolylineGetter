package railRoadElements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(
        name = "Shapes"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class Shapes {
    @XmlElement(
            name = "Railyard"
    )
    private Railyard railyard;
    @XmlElement(
            name = "RailTrack"
    )
    private List<RailTrack> railTrackList;
    @XmlElement(
            name = "RailroadSwitch"
    )
    private List<RailroadSwitch> railroadSwitchList;

    public Shapes() {
    }

    public void setRailyard(Railyard railyard) {
        this.railyard = railyard;
    }

    public void setRailTrackList(List<RailTrack> railTrackList) {
        this.railTrackList = railTrackList;
    }

    public void setRailroadSwitchList(List<RailroadSwitch> railroadSwitchList) {
        this.railroadSwitchList = railroadSwitchList;
    }
}