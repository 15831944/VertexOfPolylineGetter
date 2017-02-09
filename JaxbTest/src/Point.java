import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Point {
    private int X;
    private int Y;
    private int Z;

    public static Point initPoint(int x, int y, int z) {
        Point rez = new Point();
        rez.setX(x);
        rez.setY(y);
        rez.setZ(z);
        return rez;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setZ(int z) {
        Z = z;
    }
}