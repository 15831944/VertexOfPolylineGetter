import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RailTrack")
@XmlAccessorType(XmlAccessType.FIELD)
public class RailTrack extends RailRoadElement {
    private int Z = Constants.Z;
    private long LineColor = Constants.LINE_COLOR;
    private String LineMaterial = Constants.LINE_MATERIAL;
    private int LineWidth = Constants.LINE_WIDTH;
    private String PathType = Constants.PATH_TYPE;
    private int Width = Constants.WIDTH;
    private Points Points;
    private boolean Bidirectional = Constants.BIDIRECTIONAL;

    public void initRailTrack(String trackId, String trackName, int trackX, int trackY, Points trackPoints) {
        setId(trackId);
        setName(trackName);
        setX(trackX);
        setY(trackY);
        setPoints(trackPoints);
    }

    public void setPoints(Points points) {
        Points = points;
    }
}
