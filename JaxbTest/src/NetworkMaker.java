import railRoadElements.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NetworkMaker {
    private static int numberForTrackId = 0;
    private static int numberForTrackName = 0;
    private static int numberForYardId = 0;
    private static int numberForYardName = 0;
    private static int numberForSwitchId = 0;
    private static int numberForSwitchName = 0;


    // parse information from autocad and make shapes for xml file
    public Shapes initNetwork(File file) {
        FileFromAutoCadParser fileParser = new FileFromAutoCadParser(file);

        Shapes mainShapes = new Shapes();
        Railyard railyard = new Railyard(); // till work with one railYard
        Shapes shapes = new Shapes(); // shapes in railYard

        List<String> tracksInformationList = fileParser.getTracks(); // take information about tracks from file
        List<String> switchesInformationList = fileParser.getSwitches(); // take information about switches from file

        List<RailTrack> tracks = makeListOfTracks(tracksInformationList);
        List<RailroadSwitch> switches = makeListOfSwitches(switchesInformationList);

        shapes.setRailTrackList(tracks); // put tracks to shapes in railYard
        shapes.setRailroadSwitchList(switches); // put switches to shapes in railYard

        railyard.initRailyard(makeYardId(), makeYardName(), Constants.FIRST_X, Constants.FIRST_Y, shapes);
        mainShapes.setRailyard(railyard);

        return mainShapes;
    }

    private List<RailroadSwitch> makeListOfSwitches(List<String> switchesInformationList) {
        List<RailroadSwitch> railroadSwitchList = new ArrayList<>();
        for (String switchInform : switchesInformationList) {
            String[] xy = switchInform.split(" ");
            double x = Double.parseDouble(xy[1]);
            double y = - Double.parseDouble(xy[2]);

            RailroadSwitch railroadSwitch = new RailroadSwitch();
            railroadSwitch.initRailroadSwitch(makeSwitchId(), makeSwitchName(), Constants.FIRST_X + x, Constants.FIRST_Y + y);

            railroadSwitchList.add(railroadSwitch);
        }
        return railroadSwitchList;
    }

    private String makeTrackId() {
        numberForTrackId++;
        return String.format("1486626126%03d", numberForTrackId);
    }

    private String makeTrackName() {
        numberForTrackName++;
        return String.format("railwayTrack%d", numberForTrackName);
    }

    private String makeYardName() {
        numberForYardName++;
        return String.format("railwayNetwork%d", numberForTrackName);
    }

    private String makeYardId() {
        numberForYardId++;
        return String.format("1486646288%03d", numberForTrackId);
    }

    private String makeSwitchName() {
        numberForSwitchName++;
        return String.format("railwaySwitch%d", numberForSwitchName);
    }

    private String makeSwitchId() {
        numberForSwitchId++;
        return String.format("1487248525%03d", numberForSwitchId);
    }

    private List<RailTrack> makeListOfTracks(List<String> tracksInformationList) {
        List<RailTrack> railTrackList = new ArrayList<>();
        for (String trackInform : tracksInformationList) {
            List<Point> pointList = getListOfPoint(trackInform);
            Points points = new Points();
            points.setPoints(pointList);
            RailTrack railTrack = new RailTrack();

            railTrack.initRailTrack(makeTrackId(), makeTrackName(), Constants.FIRST_X, Constants.FIRST_Y, points);
            railTrackList.add(railTrack);
        }
        return railTrackList;
    }

    // get points for each track
    private List<Point> getListOfPoint(String track) {
        List<Point> pointList = new ArrayList<>();
        String[] strArray = track.split(" ");
        for (int i = 1; i < strArray.length-1; i = i+2) {
            double x = Double.parseDouble(strArray[i]);
            double y = - Double.parseDouble(strArray[i+1]); // mirror view in anyLogic
            Point point = Point.initPoint(x, y, 0);
            pointList.add(point);
        }
        return completeListOfPoint(pointList);
    }

    // add additional points (anyLogic curves)
    // each point in AnyLogic requires two additional points (for leverage)
    // make points in oder: 112213324435545
    private List<Point> completeListOfPoint(List<Point> pointList) {
        List<Point> newPointList = new ArrayList<>();
        Point first = pointList.get(0);
        newPointList.add(first);
        newPointList.add(first);
        for (int i = 1; i < pointList.size(); i++) {
            Point pointI = pointList.get(i);
            newPointList.add(pointI);
            newPointList.add(pointI);
            Point pointI_1 = pointList.get(i-1);
            newPointList.add(pointI_1);
        }
        newPointList.add(pointList.get(pointList.size()-1));
        return newPointList;
    }

}