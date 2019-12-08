package com.samosvat.diplom;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class XMLParser {
    int fontHeight;
    public int parse(String stringXML) {

        Node node = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dDoc = builder.parse(new ByteArrayInputStream(stringXML.getBytes()));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList) xPath.evaluate("//sz/@val", dDoc, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                fontHeight = Integer.parseInt(node.getTextContent())/2;
                node = nodes.item(i);
                System.out.println("Font size = " + fontHeight);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return fontHeight;
    }
}

////        Document document = builder.parse(new ByteArrayInputStream(stringXML.getBytes()));
//
//            Element rootElement = document.getDocumentElement();
//
//            rootElement.getAttribute("attributeName");    //returns specific attribute
//
//
//            System.out.println("Attribute:" + rootElement.getAttribute("w:sz w:val"));

