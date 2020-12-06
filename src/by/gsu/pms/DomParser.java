package by.gsu.pms;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public static void main(String[] argv) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("src/sport.rss");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);


        Element titleElement = (Element) document.getElementsByTagName("title").item(0);
        Element linkElement = (Element) document.getElementsByTagName("link").item(0);
        Element descriptionElement = (Element) document.getElementsByTagName("description").item(0);
        Element languageElement = (Element) document.getElementsByTagName("language").item(0);
        Element pubDateElement = (Element) document.getElementsByTagName("pubDate").item(0);
        Element lastBuildDateElement = (Element) document.getElementsByTagName("lastBuildDate").item(0);
        String title = titleElement.getTextContent();
        String link = linkElement.getTextContent();
        String description = descriptionElement.getTextContent();
        String language = languageElement.getTextContent();
        String pubDate = pubDateElement.getTextContent();
        String lastBuildDate = lastBuildDateElement.getTextContent();


        NodeList rateNodeList = document.getElementsByTagName("item");

        List<Item> rateList = new ArrayList<>();

        for (int i = 0; i < rateNodeList.getLength(); i++) {
            if (rateNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element rateElement = (Element) rateNodeList.item(i);

                Item item = new Item();



                NodeList childNodes = rateElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()) {
                            case "title": {
                                item.setTitle(String.valueOf(childElement.getTextContent()));
                            }
                            break;
                            case "link": {
                                item.setLink(String.valueOf(childElement.getTextContent()));
                            }
                            break;
                            case "description": {
                                item.setDescription(String.valueOf(childElement.getTextContent()));
                            }
                            break;
                            case "category": {
                                item.setCategory(String.valueOf(childElement.getTextContent()));
                                item.setDomain(String.valueOf(childElement.getAttribute("domain")));
                            }
                            break;
                            case "enclosure": {
                                item.setEnclosure(String.valueOf(childElement.getAttribute("url")));
                            }
                            break;
                            case "guid": {
                                item.setGuid(String.valueOf(childElement.getTextContent()));
                                item.setIsPermaLink(String.valueOf(childElement.getAttribute("isPermaLink")));
                            }
                            break;
                            case "pubDate": {
                                item.setPubDate(String.valueOf(childElement.getTextContent()));
                            }
                            break;
                        }
                    }
                }
                rateList.add(item);
            }
        }

        try (FileWriter files = new FileWriter("src/DOM.txt")) {

            files.write(String.valueOf(title)+"\n");
            files.write(String.valueOf(link)+"\n");
            files.write(String.valueOf(description)+"\n");
            files.write(String.valueOf(language)+"\n");
            files.write(String.valueOf(pubDate)+"\n");
            files.write(String.valueOf(lastBuildDate)+"\n");
            files.write(String.valueOf(rateList)+"\n");
        }

        System.out.println("DOM parsing is completed...");
    }
}