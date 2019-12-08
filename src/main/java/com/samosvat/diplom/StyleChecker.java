package com.samosvat.diplom;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StyleChecker {
    XWPFParagraph paragraph;

    StyleSample[] stylesArray;
    XWPFDocument doc;

    public String checkStyle(XWPFParagraph paragraph, StyleSample[] stylesArray, XWPFDocument doc) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        this.doc = doc;
        this.paragraph = paragraph;
        this.stylesArray = stylesArray;
        int j;
        String paragraphText = paragraph.getText();
        if (paragraphText.isEmpty()) return null;
        String currentKeyWord = "";

        String paragraphStyleID = readParagraphStyleID(paragraph);
        int paragraphFontHeight = getFontHeight(paragraph, doc);
        String paragraphFontName = getFontName(paragraph, doc);
        boolean paragraphIsBold = getIsBold(paragraph, doc);
        boolean paragraphIsItalic = getIsItalic(paragraph, doc);


        for (int i = 0; i < stylesArray.length; i++) {


            String defaultStyleID = stylesArray[i].getStyleID();
            int defaultFontHeight = stylesArray[i].getFontHeight();
            String defaultFontName = stylesArray[i].getFontName();
            boolean defaultIsBold = stylesArray[i].isBold();
            boolean defaultIsItalic = stylesArray[i].isItalic();


            if (paragraphText.contains(stylesArray[i].keyWords[j])) {
                System.out.println("true " + paragraphText + " contains " + stylesArray[i].keyWords[j]);
                return null;
            }
            return "i=" + i + "j=" + j + " false paragraphText " + paragraphText + " currentKeyWord " + currentKeyWord;
        }
        System.out.println("false all");
        return "false all";
    }


    private String readParagraphStyleID(XWPFParagraph paragraph) {
        return paragraph.getStyleID();
    }

    private int getFontHeight(XWPFParagraph paragraph, XWPFDocument doc) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        String styleID = paragraph.getStyleID();
//            System.out.println("StyleID: " + styleID);
//            System.out.println(paragraph.getParagraphText());
//            System.out.println(paragraph.isPageBreak());
//            System.out.println("paragraph.getAlignment() " + paragraph.getAlignment());
//            System.out.println("paragraph.getBorderBetween() " + paragraph.getBorderBetween());
//            System.out.println("paragraph.getBorderBottom " + paragraph.getBorderBottom());
//            System.out.println("paragraph.getBorderLeft() " + paragraph.getBorderLeft());
//            System.out.println("paragraph.getBorderRight() " + paragraph.getBorderRight());
//            System.out.println("paragraph.getBorderTop() " + paragraph.getBorderTop());
//            System.out.println("paragraph.getFontAlignment() " + paragraph.getFontAlignment());
//            System.out.println("paragraph.getIndentationFirstLine() " + paragraph.getIndentationFirstLine());
//            System.out.println("paragraph.getSpacingBefore() " + paragraph.getSpacingBefore());
//            System.out.println("paragraph.getSpacingAfter() " + paragraph.getSpacingAfter());
//            System.out.println("paragraph.getSpacingBetween() " + paragraph.getSpacingBetween());
//            System.out.println("paragraph.getSpacingBeforeLines() " + paragraph.getSpacingBeforeLines());

        if (styleID != null) {
            XWPFStyle xwpfStyle = doc.getStyles().getStyle(styleID);
            CTStyle ctStyle = xwpfStyle.getCTStyle();
//            System.out.println(ctStyle.toString());
            String stringXML = ctStyle.toString();
            XMLParser xmlParser = new XMLParser();
            return xmlParser.parse(ctStyle.toString());

        }
    }
}
