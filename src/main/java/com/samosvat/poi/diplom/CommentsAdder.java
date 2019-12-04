package com.samosvat.poi.diplom;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.math.BigInteger;
import java.util.*;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import javax.xml.namespace.QName;

import static org.apache.poi.ooxml.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

    public class CommentsAdder {
        public void start(ArrayList <StyleProperties> stylesArrayList) {

            for (int i = 0; i < stylesArrayList.size(); i++) {
                System.out.println(stylesArrayList.get(i).getStyleName());
            }

            String fileName = "C:\\styles4.docx";
            String fileOut = "C:\\styles44444.docx";

            try {
                XWPFDocument doc = new XWPFDocument(OPCPackage.open(fileName));

                System.out.println("Комментариев добавлено: " + findText(doc));

                for (XWPFParagraph p : doc.getParagraphs()) {
                    List<XWPFRun> runs = p.getRuns();
                    if (runs != null) {
                        for (XWPFRun r : runs) {
                            String text = r.getText(0);
                            if (text != null) {
                                text = text.concat("!!!");
                                r.setText(text, 0);
                            }
                        }
                    }
                }

                FileOutputStream out = new FileOutputStream(fileOut);
                doc.write(out);

            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        private int findText(XWPFDocument doc) throws Exception {

            String forComment1 = "Основной текст";
            String forComment2 = "Заголовок текст";
            String textComment1 = "Найден основной текст";
            String textComment2 = "Найден заголовок";

            int commentsAddedCount = 0;
            BigInteger bIg = BigInteger.ZERO;
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            System.out.println("Всего абзацев: " + paragraphs.size());
            System.out.println("Коментариев найдено: " + doc.getComments().length);

            if (doc.getComments().length == 0) {
                CommentsAdder.MyXWPFCommentsDocument myXWPFCommentsDocument = createCommentsDocument(doc);
                for (int i = 0; i < paragraphs.size(); i++) {
                    XWPFParagraph paragraph = paragraphs.get(i);
                    if (paragraph.getText().contains(forComment1)) {
                        int count = paragraph.getText().length();
                        bIg = bIg.add(BigInteger.ONE);
                        CTComments comments = myXWPFCommentsDocument.getComments();
                        CTComment ctComment = comments.addNewComment();
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
                        ctComment.setAuthor("Samosvat");
                        ctComment.setInitials("VVS");
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));

                        ctComment.addNewP().addNewR().addNewT().setStringValue(textComment1 + "\n Первый комментарий.");
                        ctComment.addNewP().addNewR().addNewT().setStringValue( "\n Также в этом абзаце " + count + " символов.");
                        ctComment.setId(bIg);
                        commentsAddedCount++;
                        paragraph.getCTP().addNewCommentRangeEnd().setId(bIg);
                        paragraph.getCTP().addNewR().addNewCommentReference().setId(bIg);
                    }
                    if (paragraph.getText().contains(forComment2)) {
                        int count = paragraph.getText().length();
                        bIg = bIg.add(BigInteger.ONE);

                        CTComments comments = myXWPFCommentsDocument.getComments();
                        CTComment ctComment = comments.addNewComment();
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
                        ctComment.setAuthor("Samosvat");
                        ctComment.setInitials("VVS");
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));

                        ctComment.addNewP().addNewR().addNewT().setStringValue(textComment2 + "\n Также в этом абзаце " + count + " символов. Второй коммент");
                        ctComment.setId(bIg);
                        commentsAddedCount++;
                        paragraph.getCTP().addNewCommentRangeEnd().setId(bIg);
                        paragraph.getCTP().addNewR().addNewCommentReference().setId(bIg);
                    }
                }
            }
            return  commentsAddedCount;
        }

        //a method for creating the CommentsDocument /word/comments.xml in the *.docx ZIP archive
        private static CommentsAdder.MyXWPFCommentsDocument createCommentsDocument(XWPFDocument document) throws Exception {
            OPCPackage oPCPackage = document.getPackage();
            PackagePartName partName = PackagingURIHelper.createPartName("/word/comments.xml");
            PackagePart part = oPCPackage.createPart(partName, "application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml");
            CommentsAdder.MyXWPFCommentsDocument myXWPFCommentsDocument = new CommentsAdder.MyXWPFCommentsDocument(part);

            String rId = "rId" + (document.getRelationParts().size() + 1);
            document.addRelation(rId, XWPFRelation.COMMENT, myXWPFCommentsDocument);

            return myXWPFCommentsDocument;
        }

        //a wrapper class for the CommentsDocument /word/comments.xml in the *.docx ZIP archive
        private static class MyXWPFCommentsDocument extends POIXMLDocumentPart {

            private CTComments comments;

            private MyXWPFCommentsDocument(PackagePart part) throws Exception {
                super(part);
                comments = CommentsDocument.Factory.newInstance().addNewComments();
            }

            private CTComments getComments() {
                return comments;
            }

            @Override
            protected void commit() throws IOException {
                XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
                xmlOptions.setSaveSyntheticDocumentElement(new QName(CTComments.type.getName().getNamespaceURI(), "comments"));
                PackagePart part = getPackagePart();
                OutputStream out = part.getOutputStream();
                comments.save(out, xmlOptions);
                out.close();
            }
        }
    }