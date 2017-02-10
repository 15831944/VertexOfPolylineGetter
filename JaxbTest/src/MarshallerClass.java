import java.io.File;
import java.util.*;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerClass {
    public static void main(String[] args) throws JAXBException {

        MarshallerClass marshallerClass = new MarshallerClass();

        File data = new File("C://data.txt");
        Shapes shapes = marshallerClass.initNetWork(data);

        JAXBContext jaxbContext = JAXBContext.newInstance(Shapes.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshal the employees list in console
        jaxbMarshaller.marshal(shapes, System.out);
        //Marshal the employees list in file
        //jaxbMarshaller.marshal(railTrack, new File("c:/file.xml"));

        // Реализовать считывание данных
    }

    public Shapes initNetWork(File file) {
        Shapes shapes = new Shapes();
        Railyard railyard = new Railyard();
        Shapes shapes1 = new Shapes();
        RailTrack railTrack = new RailTrack();
        Points points = new Points();
        List<Point> pointList = new ArrayList<Point>();
        points.setPoints(
                Point.initPoint(0, 0, 0),
                Point.initPoint(-25, 0, 0),
                Point.initPoint(25, 0, 0),
                Point.initPoint(510, 0, 0),
                Point.initPoint(485, 0, 0),
                Point.initPoint(0, 0, 0)
        );
        railTrack.initRailTrack("1486626126581", "railwayTrack", 150, 300, points);
        shapes1.setRailTrack(railTrack);
        railyard.initRailyard("1486646288415", "railwayNetwork", 150, 300, shapes1);
        shapes.setRailyard(railyard);

        return shapes;
    }
}