import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMI on 14.02.2017.
 */
public class FileParser {
    private File fileForParse;
    private List<String> tracks;

    public FileParser(File fileForParse) {
        this.fileForParse = fileForParse;
        tracks = new ArrayList<>();
    }

    public List<String> getListOfTracks() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForParse)))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("Begin:") || line.equals("End."))
                    continue;
                tracks.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла с информацией о путях!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не могу прочитать файл с информацией о путях!");
            e.printStackTrace();
        }
        return tracks;
    }

    public List<Point> getListOfPoint(String track) {
        List<Point> pointList = new ArrayList<>();
        String[] strArray = track.split(" ");
        for (int i = 1; i < strArray.length-1; i = i+2) {
            double x = Double.parseDouble(strArray[i]);
            double y = Double.parseDouble(strArray[i+1]);
            Point point = Point.initPoint(x, y, 0);
            pointList.add(point);
        }
        return completeListOfPoint(pointList);
    }

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
