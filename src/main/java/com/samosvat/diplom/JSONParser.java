package com.samosvat.diplom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONParser {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public void start () throws IOException {

//        String [] strin = new String[]{"keya", "keyb"};
//        String [] string = new String[]{"sta", "stb"};
//
//        String [] strin2 = new String[]{"keyс", "keyв"};
//        String [] string2 = new String[]{"sta324324", "stb23432432"};
//
//        List<Chapter> chapterTemplateLibrary;
//
//
//        Chapter chapter1 = new Chapter("титул",
//                "БГТУ",
//                strin,
//                string,
//        1,
//        4);
//
//        Chapter chapter2 = new Chapter("оглав",
//                "оглав",
//                strin2,
//                string2,
//                4,
//                100);
//
//        Gson gson = new Gson();
//
//        ArrayList <Chapter> chapterList = new ArrayList<>() ;
//        chapterList.add(chapter1);
//        chapterList.add(chapter2);
//
//        chapterTemplateLibrary = new ArrayList<Chapter>(chapterList);
//
//        System.out.println(GSON.toJson(chapterTemplateLibrary));
//
//        Writer writer = new FileWriter("gsonEXAMPLE2.json");
//        gson.toJson(chapterList, writer);
//
//        writer.flush();
//        writer.close();

        String path = "structureDissertation.json";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Gson gson2 = new Gson();
        Chapter [] chapterTemplateLibrary1  = gson2.fromJson(bufferedReader, Chapter[].class);

        System.out.println(GSON.toJson(chapterTemplateLibrary1));

    }

//    class ChapterTemplateLibrary {
////        ArrayList <Chapter> chapterTemplateLibraries;
//
//        ArrayList <Chapter> ChapterTemplateLibrary;
//
//        public ArrayList <Chapter> getChapterList() {
//            return chapterList;
//        }
//
//        ArrayList <Chapter> chapterList;
//
//        public int getLibraryLength(){
//            return chapterList.size();
//        }
//
//        public ChapterTemplateLibrary (ArrayList <Chapter> chapterList) {
//            this.chapterList = chapterList;
//        }
//    }

        public class Chapter {
        Chapter [] chapter;
            String chapter_name;
            String heading_name;
            String [] keywords;
            String [] stylesAllowed;
            int paragraphsCount;
            int symbolsCount;

            public Chapter(String chapter_name,
                           String heading_name,
                           String[] keywords,
                           String[] stylesAllowed,
                           int paragraphsCount,
                           int symbolsCount) {
                this.chapter_name = chapter_name;
                this.heading_name = heading_name;
                this.keywords = keywords;
                this.stylesAllowed = stylesAllowed;
                this.paragraphsCount = paragraphsCount;
                this.symbolsCount = symbolsCount;
            }

            public String getChapter_name() {
                return chapter_name;
            }

            public void setChapter_name(String chapter_name) {
                this.chapter_name = chapter_name;
            }

            public String getHeading_name() {
                return heading_name;
            }

            public void setHeading_name(String heading_name) {
                this.heading_name = heading_name;
            }

            public String[] getKeywords() {
                return keywords;
            }

            public void setKeywords(String[] keywords) {
                this.keywords = keywords;
            }

            public String[] getStylesAllowed() {
                return stylesAllowed;
            }

            public void setStylesAllowed(String[] stylesAllowed) {
                this.stylesAllowed = stylesAllowed;
            }

            public int getParagraphsCount() {
                return paragraphsCount;
            }

            public void setParagraphsCount(int paragraphsCount) {
                this.paragraphsCount = paragraphsCount;
            }

            public int getSymbolsCount() {
                return symbolsCount;
            }

            public void setSymbolsCount(int symbolsCount) {
                this.symbolsCount = symbolsCount;
            }
        }



//    private abstract class AbstractTextBlock {
//        protected abstract String getStyleTemplate();
//
//        protected abstract String getTextTemplate();
//
//        public abstract String getTextBlockName();
//
//        public abstract String getErrorText();
//
//    }
//


//        protected boolean check(VParagraph vParagraph){
//            Pattern textPattern = Pattern.compile(getTextTemplate());
//            Matcher matcher = textPattern.matcher(vParagraph.getText());
//
//            Pattern stylePattern = Pattern.compile(getStyleTemplate());
//            Matcher matcher2 = stylePattern.matcher(vParagraph.getStyle());
//
//            return vParagraph.getStyle.equals(getStyleTemplate())
//                    && matcher.matches();
//        }


//    private class InstituteName extends AbstractTextBlock{
//        public final String INSTITUTE_NAME = "INSTITUTE_NAME";
//        private String textTemplate = "~^Брянский институт~";
//        private String styleTemplate = null;
//        private String errorText = "Before this block the Institute name block is expected";
//
//        protected String getStyleTemplate(){
////		....
//            return styleTemplate;
//        }
////        protected String getTextTemplate(){};
//        public String getTextBlockName(){
//            return INSTITUTE_NAME;
//        }
//        public String getErrorText(){
//            return errorText;
//        }
    }
//
//    private class Title extends AbstractTextBlock{
//        private String textTemplate  = "~^[a-bA-Bа-яА-Я]+(.){10;}~";
//        private String styleTemplate = "";


