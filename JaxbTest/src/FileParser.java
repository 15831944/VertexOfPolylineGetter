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
        Point bufferPoint = pointList.get(0);
        newPointList.add(pointList.get(0));
        for (int i = 0; i < pointList.size()-1; i++) {
            Point point1 = pointList.get(i);
            Point point2 = pointList.get(i+1);
            List<Point> twoPoints = getTwoAdditionalPoints(point1, point2);
            newPointList.add(bufferPoint);
            newPointList.add(twoPoints.get(0));
            newPointList.add(point2);
            bufferPoint = twoPoints.get(1);
        }
        newPointList.add(bufferPoint);
        newPointList.add(pointList.get(pointList.size()-1));
        return newPointList;
    }

    private List<Point> getTwoAdditionalPoints(Point one, Point two) {
        List<Point> twoAdditionalPoints = new ArrayList<>();
        double dx = two.getX() - one.getX();
        double dy = two.getY() - one.getY();
        double tangens = dy / dx;
        double fapX = one.getX() + dx/3;
        double fapY = tangens == 0 ? one.getY() : (fapX - one.getX()) * tangens;
        Point firstAdditionalPoint = Point.initPoint(fapX, fapY, 0);
        double sapX = fapX + dx/3;
        double sapY = tangens == 0 ? one.getY() : (sapX - one.getX()) * tangens;
        Point secondAdditionalPoint = Point.initPoint(sapX, sapY, 0);
        twoAdditionalPoints.add(firstAdditionalPoint);
        twoAdditionalPoints.add(secondAdditionalPoint);
        return twoAdditionalPoints;
    }
}
