import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Created by SMI on 09.02.2017.
 */
public class MarshallerClass {
    public MarshallerClass() {
    }

    public static void main(String[] args) throws JAXBException {
        MarshallerClass marshallerClass = new MarshallerClass();
        File data = new File("");
        Shapes shapes = marshallerClass.initNetWork(data);
        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{Shapes.class});
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
        jaxbMarshaller.marshal(shapes, System.out);
    }

    public Shapes initNetWork(File file) {
        Shapes shapes = new Shapes();
        Railyard railyard = new Railyard();
        Shapes shapes1 = new Shapes();
        RailTrack railTrack = new RailTrack();
        Points points = new Points();
        points.setPoints(new Point[]
                {Point.initPoint(0, 0, 0),
                        Point.initPoint(-25, 0, 0),
                        Point.initPoint(25, 0, 0),
                        Point.initPoint(510, 0, 0),
                        Point.initPoint(485, 0, 0),
                        Point.initPoint(0, 0, 0)});
        railTrack.initRailTrack("1486626126581", "railwayTrack", 150, 300, points);
        shapes1.setRailTrack(railTrack);
        railyard.initRailyard("1486646288415", "railwayNetwork", 150, 300, shapes1);
        shapes.setRailyard(railyard);
        return shapes;
    }
}