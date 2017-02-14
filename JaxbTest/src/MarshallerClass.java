import java.io.File;
import java.util.List;

public class MarshallerClass {
    private static int numberForTrackNumber = 0;
    private static int numberForTrackName = 0;
    private static int numberForYardNumber = 0;
    private static int numberForYardName = 0;


    public Shapes initNetWork(File file) {
        FileParser fileParser = new FileParser(file);
        List<String> tracks = fileParser.getListOfTracks();
        Shapes shapes = new Shapes();
        Railyard railyard = new Railyard();
        Shapes shapes1 = new Shapes();
        RailTrack railTrack = new RailTrack();
        Points points = new Points();
        List<Point> listOfPoint = fileParser.getListOfPoint(tracks.get(0));
        points.setPoints(listOfPoint);
        railTrack.initRailTrack("1486626126581", "railwayTrack", 150, 300, points);
        shapes1.setRailTrack(railTrack);
        railyard.initRailyard("1486646288415", "railwayNetwork", 150, 300, shapes1);
        shapes.setRailyard(railyard);

        return shapes;
    }

    public String makeTrackNumber() {
        numberForTrackNumber++;
        return String.format("1486626126%03d", numberForTrackNumber);
    }

    public String makeTrackName() {
        numberForTrackName++;
        return String.format("railwayTrack%d", numberForTrackName);
    }

    public String makeYardName() {
        numberForYardName++;
        return String.format("railwayNetwork%d", numberForTrackName);
    }

    public String makeYardNumber() {
        numberForYardNumber++;
        return String.format("1486646288%03d", numberForTrackNumber);
    }

}