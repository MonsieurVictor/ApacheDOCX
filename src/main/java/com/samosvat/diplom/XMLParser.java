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
    String fontName;
    public int parseFontHeight(String stringXML) {

        Node node = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dDoc = builder.parse(new ByteArrayInputStream(stringXML.getBytes()));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList) xPath.evaluate("//sz/@val", dDoc, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                node = nodes.item(i);
                fontHeight = Integer.parseInt(node.getTextContent())/2;
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

    public String parseFontName(String stringXML) {

        Node node = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dDoc = builder.parse(new ByteArrayInputStream(stringXML.getBytes()));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList) xPath.evaluate("//rFonts/@ascii", dDoc, XPathConstants.NODESET);
            if (nodes!= null) {
                for (int i = 0; i < nodes.getLength(); i++) {
                    node = nodes.item(i);
                    fontName = node.getTextContent();
                    System.out.println("Font name = " + fontName);
                }
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
        return fontName;
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

