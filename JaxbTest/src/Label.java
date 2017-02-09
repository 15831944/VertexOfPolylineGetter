import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Label {
    private int X = Constants.LABEL_X;
    private int Y = Constants.LABEL_Y;

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }
}
