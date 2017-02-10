import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Points {
    @XmlElement(name = "Point")
    List<Point> points = new ArrayList<>();

    public void setPoints(Point... points) {
        for (Point point : points) {
            this.points.add(point);
        }
    }
}
