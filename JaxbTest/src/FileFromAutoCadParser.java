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
    private List<String> switches;

    // get information of tracks from file
    public List<String> getTracks() {
        return tracks;
    }

    // get information of switches from file
    public List<String> getSwitches() {
        return switches;
    }

    public FileFromAutoCadParser(File fileForParse) {
        this.fileForParse = fileForParse;
        tracks = new ArrayList<>();
        switches = new ArrayList<>();
        initTracksAndSwitches();
    }

    // get information from file
    private void initTracksAndSwitches() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForParse)))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("Begin:") || line.equals("End."))
                    continue;
                String beginLine = line.substring(0, 5); // check what kind of element in line
                switch (beginLine) {
                    case "track": {
                        tracks.add(line);
                        break;
                    }
                    case "switc": {
                        switches.add(line);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла с информацией о путях!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не могу прочитать файл с информацией о путях!");
            e.printStackTrace();
        }
    }
}
