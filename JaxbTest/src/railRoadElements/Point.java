package railRoadElements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Point {
    private double X;
    private double Y;
    private double Z;

    public static Point initPoint(double x, double y, double z) {
        Point rez = new Point();
        rez.setX(x);
        rez.setY(y);
        rez.setZ(z);
        return rez;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setZ(double z) {
        Z = z;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }
}