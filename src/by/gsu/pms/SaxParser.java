package by.gsu.pms;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SaxParser {
    public static void main(String[] argv) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        MyHandler handler = new MyHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse("src/sport.rss");

        Branches branches = handler.getBranches();

        try (FileWriter files = new FileWriter("src/Sax.txt")) {

            files.write(String.valueOf(branches.itemList));

        }
    }

    private static class MyHandler extends DefaultHandler{
        static final String ITEM_TAG = "item";
        static final String ITEM_TITLE_TAG = "title";
        static final String ITEM_LINK_TAG = "link";
        static final String ITEM_DESCRIPTION_TAG = "description";
        static final String ITEM_CATEGORY_TAG = "category";
        static final String ITEM_ENCLOSURE_TAG = "enclosure";
        static final String ITEM_GUID_TAG = "guid";
        static final String ITEM_PUB_DATE_TAG = "pubDate";

        static final String CATEGORY_DOMAIN = "domain";
        static final String ENCLOSURE_URL = "url";
        static final String GUID_IS_PERMA_LINK = "isPermaLink";

        private Branches branches;
        private Item items;
        private String channelElement;

        Branches getBranches(){
            return branches;
        }

        public void startDocument() throws SAXException {
            // System.out.println("");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            channelElement = qName;


            switch (channelElement) {
                case ITEM_TAG: {
                    branches = new Branches();
                    branches.itemList = new ArrayList<>();

                } break;
                case ITEM_CATEGORY_TAG: {
                    items = new Item();

                    items.setDomain(String.valueOf(attributes.getValue(CATEGORY_DOMAIN)));

                } break;
                case ITEM_GUID_TAG: {
                    items.setUrl(String.valueOf(attributes.getValue(ENCLOSURE_URL)));

                } break;
                case ITEM_ENCLOSURE_TAG: {
                    items.setIsPermaLink(String.valueOf(attributes.getValue(GUID_IS_PERMA_LINK)));

                } break;

                default: {

                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);

            if (text.contains("<") || channelElement == null){
                return;
            }

            switch (channelElement) {
                case ITEM_TITLE_TAG: {
                    items.setTitle(text);
                } break;

                case ITEM_LINK_TAG: {
                    items.setLink(text);
                } break;

                case ITEM_DESCRIPTION_TAG: {
                    items.setDescription(text);
                } break;
                case ITEM_CATEGORY_TAG: {
                    items.setCategory(text);
                } break;
                case ITEM_GUID_TAG: {
                    items.setGuid(text);
                } break;
                case ITEM_PUB_DATE_TAG: {
                    items.setPubDate(text);
                } break;

                default: {

                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException{
            switch (qName) {
                case ITEM_TAG: {
                    branches.itemList.add(items);
                    items = null;

                } break;

                default: {

                }
            }
            channelElement = null;
        }

        public void endDocument() throws SAXException {
            System.out.println("SAX parsing is completed...");
        }
    }
}

class Branches {
    List<Item> itemList;
}



