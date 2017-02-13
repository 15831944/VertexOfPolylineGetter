
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.dom4j.DocumentHelper;

@XmlRootElement
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

    public RailTrack() {
        super();
    }

    public void initRailTrack(String id, String name, int x, int y, Points points) {
        setId(id);
        setName(name);
        setX(x);
        setY(y);
        setPoints(points);
    }

    public void setPoints(Points points) {
        Points = points;
    }
}
