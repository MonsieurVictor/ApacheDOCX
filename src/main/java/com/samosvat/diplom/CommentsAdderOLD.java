//package com.samosvat.poi.diplom;
//
//import org.apache.poi.ooxml.POIXMLDocumentPart;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.openxml4j.opc.PackagePart;
//import org.apache.poi.openxml4j.opc.PackagePartName;
//import org.apache.poi.openxml4j.opc.PackagingURIHelper;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRelation;
//import org.apache.xmlbeans.XmlOptions;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;
//
//import javax.xml.namespace.QName;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.math.BigInteger;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.Locale;
//
//import static org.apache.poi.ooxml.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;
//
//public class CommentsAdderOLD {
//
//    public void start() {
//        String forComment1 = "Велес";
//        String forComment2 = "бог";
//
//        String textComment1 = "У цьому абзацы э згадування про Бога торгівлі та підземного світу.";
//        String textComment2 = "Тут про богов щось е.";
//
//        String fileName = "C:\\mifolog.docx";
//        String fileOut = "C:\\mifolog111.docx";
//
//        int commentsAddedCount = 0;
//
//        XWPFDocument doc = null;
//        try {
//            doc = new XWPFDocument(OPCPackage.open(fileName));
//            BigInteger bIg = BigInteger.ZERO;
//            List<XWPFParagraph> paragraphs = doc.getParagraphs();
//            System.out.println("Всего абзацев: " + paragraphs.size());
//            System.out.println("Коментариев найдено: " + doc.getComments().length);
//            if (doc.getComments().length == 0) {
//                CommentsAdderOLD.MyXWPFCommentsDocument myXWPFCommentsDocument = createCommentsDocument(doc);
//                for (int i = 0; i < paragraphs.size(); i++) {
//                    XWPFParagraph paragraph = paragraphs.get(i);
//                    if (paragraph.getText().contains(forComment1)) {
//                        int count = paragraph.getText().length();
//                        bIg = bIg.add(BigInteger.ONE);
//                        CTComments comments = myXWPFCommentsDocument.getComments();
//                        CTComment ctComment = comments.addNewComment();
//                        ctComment.setAuthor("Oleh Savenko");
//                        ctComment.setInitials("OS");
//                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
//                        ctComment.addNewP().addNewR().addNewT().setStringValue(textComment1 + "\n Це перший коммент.");
//                        ctComment.setId(bIg);
//                        commentsAddedCount++;
//                        paragraph.getCTP().addNewCommentRangeEnd().setId(bIg);
//                        paragraph.getCTP().addNewR().addNewCommentReference().setId(bIg);
//                    }
//                    if (paragraph.getText().contains(forComment2)) {
//                        int count = paragraph.getText().length();
//                        bIg = bIg.add(BigInteger.ONE);
//                        CTComments comments = myXWPFCommentsDocument.getComments();
//                        CTComment ctComment = comments.addNewComment();
//                        ctComment.setAuthor("Oleh Savenko");
//                        ctComment.setInitials("OS");
//                        ctComment.setDate(new GregorianCalendar(Locale.getDefault()));
//                        ctComment.addNewP().addNewR().addNewT().setStringValue(textComment2 + "\n Також у цьому абзаці " + count + " символыв. Другий коммент");
//                        ctComment.setId(bIg);
//                        commentsAddedCount++;
//                        paragraph.getCTP().addNewCommentRangeEnd().setId(bIg);
//                        paragraph.getCTP().addNewR().addNewCommentReference().setId(bIg);
//                    }
//                }
//            }
//            System.out.println("Комментариев добавлено: " + commentsAddedCount);
//            FileOutputStream out = new FileOutputStream(fileOut);
//            doc.write(out);
//
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //a method for creating the CommentsDocument /word/comments.xml in the *.docx ZIP archive
//    private static CommentsAdderOLD.MyXWPFCommentsDocument createCommentsDocument(XWPFDocument document) throws Exception {
//        OPCPackage oPCPackage = document.getPackage();
//        PackagePartName partName = PackagingURIHelper.createPartName("/word/comments.xml");
//        PackagePart part = oPCPackage.createPart(partName, "application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml");
//        CommentsAdderOLD.MyXWPFCommentsDocument myXWPFCommentsDocument = new CommentsAdderOLD.MyXWPFCommentsDocument(part);
//
//        String rId = "rId" + (document.getRelationParts().size() + 1);
//        document.addRelation(rId, XWPFRelation.COMMENT, myXWPFCommentsDocument);
//
//        return myXWPFCommentsDocument;
//    }
//
//    //a wrapper class for the CommentsDocument /word/comments.xml in the *.docx ZIP archive
//    private static class MyXWPFCommentsDocument extends POIXMLDocumentPart {
//
//        private CTComments comments;
//
//        private MyXWPFCommentsDocument(PackagePart part) throws Exception {
//            super(part);
//            comments = CommentsDocument.Factory.newInstance().addNewComments();
//        }
//
//        private CTComments getComments() {
//            return comments;
//        }
//
//        @Override
//        protected void commit() throws IOException {
//            XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
//            xmlOptions.setSaveSyntheticDocumentElement(new QName(CTComments.type.getName().getNamespaceURI(), "comments"));
//            PackagePart part = getPackagePart();
//            OutputStream out = part.getOutputStream();
//            comments.save(out, xmlOptions);
//            out.close();
//        }
//    }
//}