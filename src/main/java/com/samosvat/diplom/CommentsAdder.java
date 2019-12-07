package com.samosvat.diplom;

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
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import static org.apache.poi.ooxml.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

    public class CommentsAdder {

        XWPFDocument doc;
        List<XWPFParagraph> paragraphs;
        StyleSample styleSample;
        StyleSample [] stylesArray;
        Chapter chapter;
        Chapter[] chaptersArray;
        int chapterCount;
        ChapterChecker chapterChecker;

        public void start(StyleSample[] stylesArray, Chapter[] chaptersArray) {

            chapterChecker = new ChapterChecker(chaptersArray);

            this.stylesArray = stylesArray;
            this.chaptersArray = chaptersArray;
//            System.out.println("Styles from stylesArray:");
//            for (int i = 0; i < stylesArray.length; i++) {
//                System.out.println(stylesArray[i].getStyleID());
//            }

            System.out.println("-------------------------------");
            String fileName = "C:\\DisV51.docx";
            String fileOut = "C:\\styles44444.docx";
            try {
                doc = new XWPFDocument(OPCPackage.open(fileName));
                paragraphs = doc.getParagraphs();
                System.out.println("Комментариев добавлено: " + findText());
//                readParagraphStyle();
                FileOutputStream out = new FileOutputStream(fileOut);
                doc.write(out);
                out.close();
//                doc.close();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private int findText() throws Exception {

            String forComment1 = "процесс";
            String textComment1 = "Найден процесс";

            int commentsAddedCount = 0;
            BigInteger bIg = BigInteger.ZERO;

            System.out.println("Коментариев найдено: " + doc.getComments().length);

            if (doc.getComments().length == 0) {
                chapterCount = 0;

                CommentsAdder.MyXWPFCommentsDocument myXWPFCommentsDocument = createCommentsDocument(doc);
                System.out.println("Число параграфов: " + paragraphs.size());
                for (int i = 0; i < paragraphs.size(); i++) {

                    XWPFParagraph paragraph = paragraphs.get(i);
                    getFontSize(paragraph);
                    String errorMessage =  chapterChecker.checkChapter(paragraph);


                    if (errorMessage != null) {
                        int count = paragraph.getText().length();
                        bIg = bIg.add(BigInteger.ONE);
                        CTComments comments = myXWPFCommentsDocument.getComments();
                        CTComment ctComment = comments.addNewComment();
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
                        ctComment.setAuthor("Samosvat");
                        ctComment.setInitials("VVS");
                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
                        ctComment.addNewP().addNewR().addNewT().setStringValue(errorMessage);
                        ctComment.addNewP().addNewR().addNewT().setStringValue( "\n Также в этом абзаце " + count + " символов.");
                        ctComment.setId(bIg);
                        commentsAddedCount++;
                        paragraph.getCTP().addNewCommentRangeEnd().setId(bIg);
                        paragraph.getCTP().addNewR().addNewCommentReference().setId(bIg);

                    }
                }
            }
            return  commentsAddedCount;
        }

        private void getFontSize (XWPFParagraph paragraph) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
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

            if(styleID != null) {

            XWPFStyle xwpfStyle= doc.getStyles().getStyle(styleID);
            CTStyle ctStyle = xwpfStyle.getCTStyle();
//            System.out.println(ctStyle.toString());
            String stringXML = ctStyle.toString();
            XMLParser xmlParser = new XMLParser();
            xmlParser.parse(ctStyle.toString());
            }
        }

        private void readParagraphStyle () {
            Iterator<XWPFParagraph> paragraphIterator = null;
            paragraphIterator = paragraphs.iterator();
            List<IBodyElement> iBodyElementList = doc.getBodyElements();
            XWPFParagraph paragraph = null;

            for (IBodyElement p : iBodyElementList) {
                XWPFStyle style = null;
                BodyElementType bodyElementType = p.getElementType();
                if (bodyElementType.compareTo(BodyElementType.PARAGRAPH) == 0) {
                        if (paragraphIterator.hasNext()) {
                            paragraph = paragraphIterator.next();
                            System.out.println("getStyleID(): " + paragraph.getStyleID() + "; getStyle(): " + paragraph.getStyle() + "; getText(): "+ paragraph.getText() );
                        }
                }
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                xmlOptions.setSaveSyntheticDocumentElement(new QName(CTComments.type.getName().getNamespaceURI(), "comments"));
                PackagePart part = getPackagePart();
                OutputStream out = part.getOutputStream();
                comments.save(out, xmlOptions);
                out.close();
            }
        }
    }