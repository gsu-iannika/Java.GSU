import by.gsu.pms.DomParser;
import by.gsu.pms.SaxParser;
import by.gsu.pms.StaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Run {
    public static void main(String argv[]) throws ParserConfigurationException {

        try {
            DomParser.main (argv);
            SaxParser.main (argv);
            StaxParser.main (argv);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.exit(0);

    }

}
