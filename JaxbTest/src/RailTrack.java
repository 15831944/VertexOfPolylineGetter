
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.dom4j.DocumentHelper;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RailTrack {
    private String Id;
    private String Name;
    private int X;
    private int Y;
    private Label Label;
    private Points Points;
    private boolean PublicFlag = Constants.PUBLIC_FLAG;
    private boolean PresentationFlag = Constants.PRESENTATION_FLAG;
    private boolean ShowLabel = Constants.SHOW_LABEL;
    private String DrawMode = Constants.DRAW_MODE;
    private int Z = Constants.Z;
    private long LineColor = Constants.LINE_COLOR;
    private String LineMaterial = Constants.LINE_MATERIAL;
    private int LineWidth = Constants.LINE_WIDTH;
    private String PathType = Constants.PATH_TYPE;
    private int Width = Constants.WIDTH;
    private boolean Bidirectional = Constants.BIDIRECTIONAL;

    public void initRailTrack(String id, String name, int x, int y, Points points) {
        setId(id);
        setName(name);
        setX(x);
        setY(y);
        setPoints(points);
    }

    public void setId(String id) {
        Id = id;
    }

    // replace?
    @XmlCDATA
    public void setName(String name) {
        Name = DocumentHelper.createCDATA(name).asXML();
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }


    public void setLabel(int x, int y) {
        Label = new Label();
        Label.setX(x);
        Label.setY(y);
    }

    public void setPoints(Points points) {
        Points = points;
    }

    public void setPublicFlag(boolean publicFlag) {
        PublicFlag = publicFlag;
    }

    public void setPresentationFlag(boolean presentationFlag) {
        PresentationFlag = presentationFlag;
    }

    public void setShowLabel(boolean showLabel) {
        ShowLabel = showLabel;
    }

    public void setDrawMode(String drawMode) {
        DrawMode = drawMode;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void setLineColor(long lineColor) {
        LineColor = lineColor;
    }

    public void setLineMaterial(String lineMaterial) {
        LineMaterial = lineMaterial;
    }

    public void setLineWidth(int lineWidth) {
        LineWidth = lineWidth;
    }

    public void setPathType(String pathType) {
        PathType = pathType;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public void setBidirectional(boolean bidirectional) {
        Bidirectional = bidirectional;
    }
}
