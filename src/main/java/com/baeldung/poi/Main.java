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
//        WordModifierNoIntact wordModifierNoIntact = new WordModifierNoIntact();
//        wordModifierNoIntact.start();

//        WordKeepFormat wordKeepFormat = new WordKeepFormat();
//        Path msWordPath = Paths.get("C://disV5.docx");
//        XWPFDocument document2 = new XWPFDocument(Files.newInputStream(msWordPath));
//        List<XWPFParagraph> paragraphs = document2.getParagraphs();
//        document2.close();
//        System.out.println("_________________________________________");
//        for (XWPFParagraph paragraph : paragraphs) {
//            wordKeepFormat.replace(paragraph, "студент", "студент!!!!!!!!!");
//        };


        XWPFDocument document = new XWPFDocument(new FileInputStream("C://styles3.docx"));

        System.out.println(document.getStyles().styleExist("SAMOSVAT"));
        System.out.println(document.getStyles().getStyle("SAMOSVAT").getName());

        XWPFParagraph paragraph=document.createParagraph();
        paragraph.setStyle("SAMOSVAT");
        XWPFRun run=paragraph.createRun();
        run.setText("TEST");

        document.write(new FileOutputStream("docs//stylestest.docx"));
        document.close();
    }
}

