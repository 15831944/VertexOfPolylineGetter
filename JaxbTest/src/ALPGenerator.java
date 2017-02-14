import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by SMI on 13.02.2017.
 */
public class ALPGenerator {
    public static void main(String[] args) {
        File file = new File("polylineInformation.txt");
        ALPGenerator alpGenerator = new ALPGenerator();
        alpGenerator.makeALP(file);

    }

    public void makeALP(File file) {
        MarshallerClass marshallerClass = new MarshallerClass();
        Shapes shapes = marshallerClass.initNetWork(file);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{Shapes.class});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            jaxbMarshaller.marshal(shapes, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
