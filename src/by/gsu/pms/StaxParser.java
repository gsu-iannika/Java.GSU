package by.gsu.pms;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {
    public static void main(String[] argv) throws IOException {
        String fileName = "src/sport.rss";
        List<Item> itemList = parseXML(fileName);

        System.out.println("Stax parsing is completed...");

        try (FileWriter files = new FileWriter("src/Stax.txt")) {
            files.write(String.valueOf(itemList));
        }
    }

    private static List<Item> parseXML(String fileName) {
        List<Item> itemList = new ArrayList<>();
        Item item = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();

//                    if(startElement.getName().getLocalPart().equals("item")){
////                        item = new Item();
//
//
//                        if(currency != null && unit != null){
////                            rate.setCurrency((currency.getValue()));
////                            rate.setUnits((unit.getValue()));
////                            rate.setName("Головной банк");
//                        }
//                    }

                    if(startElement.getName().getLocalPart().equals("title")){
                        item = new Item();

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setTitle(xmlEvent.asCharacters().getData());

                    }else if(startElement.getName().getLocalPart().equals("link")){

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setLink(xmlEvent.asCharacters().getData());

                    }else if(startElement.getName().getLocalPart().equals("description")){

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setDescription(xmlEvent.asCharacters().getData());

                    }
                    else if(startElement.getName().getLocalPart().equals("category")){

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setCategory(xmlEvent.asCharacters().getData());

                        Attribute domain = startElement.getAttributeByName(new QName("domain"));
                        if(domain != null){
                            item.setDomain((domain.getValue()));
                        }

                    }else if(startElement.getName().getLocalPart().equals("enclosure")){

                        Attribute url = startElement.getAttributeByName(new QName("url"));
                        if(url != null){
                            item.setUrl((url.getValue()));
                        }

                    }else if(startElement.getName().getLocalPart().equals("guid")){

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setGuid(xmlEvent.asCharacters().getData());

                        Attribute isPermaLink = startElement.getAttributeByName(new QName("isPermaLink"));
                        if(isPermaLink != null){
                            item.setIsPermaLink((isPermaLink.getValue()));
                        }

                    }else if(startElement.getName().getLocalPart().equals("pubDate")){

                        xmlEvent = xmlEventReader.nextEvent();
                        item.setPubDate(xmlEvent.asCharacters().getData());

                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("item")) {
                        itemList.add(item);

                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
