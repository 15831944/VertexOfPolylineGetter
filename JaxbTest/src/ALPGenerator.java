import railRoadElements.Shapes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Generate AnyLogic view of railroad netWork to add it in (.alp)
 */
public class ALPGenerator {
    public static void main(String[] args) {
        // get information from autoCad from this file
        File file = new File("polylineInformation.txt");

        ALPGenerator alpGenerator = new ALPGenerator();
        alpGenerator.printTracksAsXML(file); // generate xml tree

    }

    public void printTracksAsXML(File file) {
        NetworkMaker networkMaker = new NetworkMaker();
        Shapes shapes = networkMaker.initNetwork(file);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{Shapes.class});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            // result file
            File rezFile = new File("forAnyAlp.txt");
            //jaxbMarshaller.marshal(shapes, System.out);
            jaxbMarshaller.marshal(shapes, rezFile);
            replaceInFile(rezFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void replaceInFile(File file) {
        try
        {
            File tempFile = new File("buffer.tmp");
            FileWriter fw = new FileWriter(tempFile);

            Reader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()) {
                String str = br.readLine();
                str = str.replaceAll("&lt;", "<");
                str = str.replaceAll("&gt;", ">");
                fw.write(str + "\n");
            }

            fw.close();
            br.close();
            fr.close();

            // Finally replace the original file.
            Path from = tempFile.toPath(); //convert from File to Path
            Path to = file.toPath();
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            tempFile.delete();

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при замене символов в результирующем файле!");
            e.printStackTrace();
        }
    }
}
