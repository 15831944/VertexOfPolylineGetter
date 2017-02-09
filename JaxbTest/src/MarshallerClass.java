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
    public static void main(String[] args) throws JAXBException {

        RailTrack railTrack = new RailTrack();

        Points points = new Points();
        List<Point> pointList = new ArrayList<Point>();
        points.setPoints(
                Point.initPoint(0, 0, 0),
                Point.initPoint(-25, 0, 0),
                Point.initPoint(25, 0, 0),
                Point.initPoint(410, 0, 0),
                Point.initPoint(385, 0, 0),
                Point.initPoint(-90, 0, 0)
        );

        railTrack.initRailTrack("1486626126581", "railwayTrack", 130, 350, points);

        JAXBContext jaxbContext = JAXBContext.newInstance(RailTrack.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshal the employees list in console
        jaxbMarshaller.marshal(railTrack, System.out);
        //Marshal the employees list in file
        //jaxbMarshaller.marshal(railTrack, new File("c:/file.xml"));


        // Изменить порядок следования элементов!!!!!!
    }
}