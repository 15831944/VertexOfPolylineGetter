import railRoadElements.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Give all information about autoCad file
 */
public class FileFromAutoCadParser {
    private File fileForParse;
    private List<String> tracks;

    public FileFromAutoCadParser(File fileForParse) {
        this.fileForParse = fileForParse;
        tracks = new ArrayList<>();
    }

    // get information of tracks from file
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
}
