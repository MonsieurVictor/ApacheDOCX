package com.samosvat.diplom;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class StyleChecker {
    XWPFParagraph paragraph;
    StyleSample[] stylesArray;
    XWPFDocument doc;

    public StyleChecker(StyleSample[] stylesArray) {
        this.stylesArray = stylesArray;
    }

    public String checkStyle(XWPFParagraph paragraph, StyleSample[] stylesArray, XWPFDocument doc) throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        String errorMessage = "";

        this.doc = doc;
        this.paragraph = paragraph;
        this.stylesArray = stylesArray;
        String paragraphText = paragraph.getText();
        if (paragraphText.isEmpty()) return null;
//        String currentKeyWord = "";

        String paragraphStyleID = paragraph.getStyleID();
        int paragraphFontHeight = getFontHeight(paragraph, doc);
        String paragraphFontName = getFontName(paragraph, doc);
//        boolean paragraphIsBold = getIsBold(paragraph, doc);
//        boolean paragraphIsItalic = getIsItalic(paragraph, doc);

        for (int i = 0; i < stylesArray.length; i++) {

            errorMessage = "";
            String defaultStyleID = stylesArray[i].getStyleID();

            if (paragraphStyleID == null) {
                return "paragraphStyleID = null";
            } else {
                if (defaultStyleID.equals(paragraphStyleID)) {
                    int defaultFontHeight = stylesArray[i].getFontHeight();
                    String defaultFontName = stylesArray[i].getFontName();
                    boolean defaultIsBold = stylesArray[i].isBold();
                    boolean defaultIsItalic = stylesArray[i].isItalic();

                    if (paragraphFontHeight == 0) {
                        return "paragraphFontHeight == 0";
                    } else {
                        if (defaultFontHeight == paragraphFontHeight) {
                            System.out.println(errorMessage);
                        } else {
                            errorMessage += "размер шрифта: " + paragraphFontHeight + ". Требуется: " + defaultFontHeight;
                        }
                    }
                    if (paragraphFontName == null) {
                        return "paragraphFontName == null";
                    } else {
                        if (defaultFontName.equals(paragraphFontName)) {
                            System.out.println(errorMessage);
                        } else {
                            errorMessage += "Имя шрифта: " + paragraphFontName + ". Требуется: " + defaultFontName;
                        }
                    }
                    if (errorMessage.equals("")){
                        return errorMessage;
                    }
                    return errorMessage;
                }
            }
        }
        errorMessage = "Стиль не найден";
        System.out.println(errorMessage);
        return errorMessage;
    }

    private int getFontHeight(XWPFParagraph paragraph, XWPFDocument doc) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        int fontHeight;
        String styleID = paragraph.getStyleID();
        XWPFRun run = paragraph.getRuns().get(0);
        fontHeight = run.getFontSize();
        System.out.println("fontHeight= " + fontHeight);

        if (styleID != null) {
            XWPFStyle xwpfStyle = doc.getStyles().getStyle(styleID);
            CTStyle ctStyle = xwpfStyle.getCTStyle();
//            System.out.println(ctStyle.toString());
            String stringXML = ctStyle.toString();
            XMLParser xmlParser = new XMLParser();
            if (fontHeight != -1){
                return fontHeight;
            } else {
                fontHeight = xmlParser.parseFontHeight(ctStyle.toString());
                return fontHeight;
            }
        }
        return fontHeight;
    }

    private String getFontName(XWPFParagraph paragraph, XWPFDocument doc) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {

        String styleID = paragraph.getStyleID();
        String fontName;
        XWPFRun run = paragraph.getRuns().get(0);
        fontName = run.getFontName();
        System.out.println("fontName= " + fontName);
        if (styleID != null) {
            XWPFStyle xwpfStyle = doc.getStyles().getStyle(styleID);
            CTStyle ctStyle = xwpfStyle.getCTStyle();
//            System.out.println(ctStyle.toString());
            String stringXML = ctStyle.toString();
            XMLParser xmlParser = new XMLParser();
            if (fontName != null){
                return fontName;
            } else {
                fontName = xmlParser.parseFontName(ctStyle.toString());
                return fontName;
            }
        }
        return null;
    }
}

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
