package com.samosvat.diplom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JSONParser {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public Chapter [] start () throws IOException {

//        String [] strin = new String[]{"keya", "keyb"};
//        String [] string = new String[]{"sta", "stb"};
//
//        String [] strin2 = new String[]{"keyс", "keyв"};
//        String [] string2 = new String[]{"sta324324", "stb23432432"};
//
//        List<Chapter> chapterTemplateLibrary;
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
        Gson gson = new Gson();
        Chapter [] chaptersArray  = gson.fromJson(bufferedReader, Chapter[].class);

        System.out.println(GSON.toJson(chaptersArray));

        return chaptersArray;

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


