//package by.gsu.pms;
//
//
//import com.sun.deploy.net.HttpResponse;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;
//import sun.rmi.runtime.Log;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.IOException;
//import java.io.StringReader;
//import java.io.UnsupportedEncodingException;
//
//public class XMLParser {
//
//     static final String URL = "http://news.tut.by/rss/sport.rss";
//
//    //Getting XML content by making HTTP Request
//    public String getXmlFromUrl(String url) {
//        String xml = null;
//
//        try {
//            // defaultHttpClient
//            DefaultHttpClient httpClient = new DefaultHttpClient();
//            HttpPost httpPost = new HttpPost(url);
//
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//            HttpEntity httpEntity = httpResponse.getEntity();
//            xml = EntityUtils.toString(httpEntity);
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // return XML
//        return xml;
//    }
//
//
//    //Parsing XML content and getting DOM element
//    public Document getDomElement(String xml){
//        Document doc = null;
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//
//            DocumentBuilder db = dbf.newDocumentBuilder();
//
//            InputSource is = new InputSource();
//            is.setCharacterStream(new StringReader(xml));
//            doc = db.parse(is);
//
//        } catch (ParserConfigurationException e) {
//            Log.e("Error: ", e.getMessage());
//            return null;
//        } catch (SAXException e) {
//            Log.e("Error: ", e.getMessage());
//            return null;
//        } catch (IOException e) {
//            Log.e("Error: ", e.getMessage());
//            return null;
//        }
//        // return DOM
//        return doc;
//    }
//
//
//    //Get each xml child element value by passing element node name
//    public String getValue(Element item, String str) {
//        NodeList nodeList = item.getElementsByTagName(str);
//        return this.getElementValue(nodeList.item(0));
//    }
//
//    public final String getElementValue( Node element ) {
//        Node child;
//        if( element != null){
//            if (element.hasChildNodes()){
//                for( child = element.getFirstChild(); child != null; child = child.getNextSibling() ){
//                    if( child.getNodeType() == Node.TEXT_NODE  ){
//                        return child.getNodeValue();
//                    }
//                }
//            }
//        }
//        return "";
//    }
//}
