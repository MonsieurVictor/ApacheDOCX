package com.baeldung.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static String logo = "logo-leaf.png";
    public static String paragraph1 = "poi-word-para1.txt";
    public static String paragraph2 = "poi-word-para2.txt";
    public static String paragraph3 = "poi-word-para3.txt";
    public static String output = "rest-with-spring.docx";

    public static void main(String args[]) throws Exception {
//        XWPFDocument document = new XWPFDocument();
//
//        XWPFParagraph title = document.createParagraph();
//        title.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun titleRun = title.createRun();
//        titleRun.setText("Build Your REST API with Spring");
//        titleRun.setColor("009933");
//        titleRun.setBold(true);
//        titleRun.setFontFamily("Courier");
//        titleRun.setFontSize(20);
//
//        XWPFParagraph subTitle = document.createParagraph();
//        subTitle.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun subTitleRun = subTitle.createRun();
//        subTitleRun.setText("from HTTP fundamentals to API Mastery");
//        subTitleRun.setColor("00CC44");
//        subTitleRun.setFontFamily("Courier");
//        subTitleRun.setFontSize(16);
//        subTitleRun.setTextPosition(20);
//        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//
//        XWPFParagraph image = document.createParagraph();
//        image.setAlignment(ParagraphAlignment.CENTER);
//        XWPFRun imageRun = image.createRun();
//        imageRun.setTextPosition(20);
//        Path imagePath = Paths.get(ClassLoader.getSystemResource(logo).toURI());
//        imageRun.addPicture(Files.newInputStream(imagePath), XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(), Units.toEMU(50), Units.toEMU(50));
//
//        XWPFParagraph sectionTitle = document.createParagraph();
//        XWPFRun sectionTRun = sectionTitle.createRun();
//        sectionTRun.setText("What makes a good API?");
//        sectionTRun.setColor("00CC44");
//        sectionTRun.setBold(true);
//        sectionTRun.setFontFamily("Courier");
//
//        XWPFParagraph para1 = document.createParagraph();
//        para1.setAlignment(ParagraphAlignment.BOTH);
//        String string1 = convertTextFileToString(paragraph1);
//        XWPFRun para1Run = para1.createRun();
//        para1Run.setText(string1);
//
//        XWPFParagraph para2 = document.createParagraph();
//        para2.setAlignment(ParagraphAlignment.RIGHT);
//        String string2 = convertTextFileToString(paragraph2);
//        XWPFRun para2Run = para2.createRun();
//        para2Run.setText(string2);
//        para2Run.setItalic(true);
//
//        XWPFParagraph para3 = document.createParagraph();
//        para3.setAlignment(ParagraphAlignment.LEFT);
//        String string3 = convertTextFileToString(paragraph3);
//        XWPFRun para3Run = para3.createRun();
//        para3Run.setText(string3);
//
//        FileOutputStream out = new FileOutputStream(output);
//        document.write(out);
//        out.close();
//        document.close();

        Path msWordPath = Paths.get("C://disV5.docx");
        XWPFDocument document2 = new XWPFDocument(Files.newInputStream(msWordPath));
        List<XWPFParagraph> paragraphs = document2.getParagraphs();
        document2.close();

//        try {
//
//
//            FileInputStream fis = new FileInputStream("annotation.docx");
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//            List <XWPFPictureData> pic = xdoc.getAllPictures();
//            if (!pic.isEmpty()) {
//                System.out.println(pic.get(0).getPictureType());
//                System.out.println(pic.get(0).getData());
//                System.out.println(pic.get(0).getFileName());
//            }
//            if (!pic.isEmpty()) {
//                System.out.println(pic.get(1).getPictureType());
//                System.out.println(pic.get(1).getData());
//                System.out.println(pic.get(1).getFileName());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        System.out.println("_________________________________________");
        for (XWPFParagraph paragraph:paragraphs) {
            System.out.println(paragraph.getAlignment());
            for (XWPFRun rn : paragraph.getRuns()) {
                System.out.println(rn);
                System.out.println("rn.isBold() " + rn.isBold());
                System.out.println("rn.isHighlighted() " + rn.isHighlighted());
                System.out.println("rn.isCapitalized() " + rn.isCapitalized());
                System.out.println("rn.getFontSize() " + rn.getFontSize());
            }

            System.out.println(paragraph.getIndentationFirstLine());


            System.out.println(paragraph.getText());
            System.out.println("********************************************************************");

        }
        XWPFDocument doc = new XWPFDocument(OPCPackage.open("C://disV5.docx"));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null ) {
                        text = text.concat("!!!");
                        r.setText(text,0);
                    }
                }
            }
        }
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            p.setWordWrapped(true);
                            String text = r.getText(0);
                            if (text != null) {
                                text = text.concat("!!!");
                                r.setText(text,0);
                            }
                        }
                    }
                }
            }
        }
        doc.write(new FileOutputStream("C://disV5output.docx"));
        System.out.println("success!");
    }

    public static String convertTextFileToString(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            return stream.collect(Collectors.joining(" "));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }



}

