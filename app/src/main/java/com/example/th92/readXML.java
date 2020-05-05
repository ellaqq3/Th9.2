package com.example.th92;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class readXML {

    private static readXML xml = null;
    private ArrayList<Smartpost> posts = new ArrayList<Smartpost>();

    private readXML(){
    }

    public static readXML getInstance() {
        if (xml == null) {
            xml = new readXML();
        }
        return xml;
    }

    public void getPosts(){
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlStringFin = " http://iseteenindus.smartpost.ee/api/?request=destinations&country=FI&type=APT";
            String urlStringEst = "http://iseteenindus.smartpost.ee/api/?request=destinations&country=EE&type=APT";
            Document docFin = builder.parse(urlStringFin);
            Document docEst = builder.parse(urlStringEst);
            docFin.getDocumentElement().normalize();
            docEst.getDocumentElement().normalize();

            NodeList nListFin = docFin.getDocumentElement().getElementsByTagName("item");

            for (int i=0; i<nListFin.getLength(); i++) {
                Node node = nListFin.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nameF = element.getElementsByTagName("name").item(0).getTextContent();
                    String locationF = element.getElementsByTagName("country").item(0).getTextContent();
                    String addressF = element.getElementsByTagName("address").item(0).getTextContent();
                    String availabilityF = element.getElementsByTagName("availability").item(0).getTextContent();
                    posts.add(new Smartpost(nameF,locationF, addressF, availabilityF));
                }
            }

            NodeList nListEst = docEst.getDocumentElement().getElementsByTagName("item");
            for (int i=0; i<nListEst.getLength(); i++) {
                Node node = nListEst.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nameE = element.getElementsByTagName("name").item(0).getTextContent();
                    String locationE = element.getElementsByTagName("country").item(0).getTextContent();
                    String addressE = element.getElementsByTagName("address").item(0).getTextContent();
                    String availabilityE = element.getElementsByTagName("availability").item(0).getTextContent();
                    posts.add(new Smartpost(nameE,locationE, addressE, availabilityE));
                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } finally {
            System.out.println("############# DONE ##############");
        }
    }
}
