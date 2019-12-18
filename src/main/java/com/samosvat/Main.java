package com.samosvat;

import com.samosvat.diplom.*;

public class Main {
//    public static void main(String[] args) throws Exception {
//
//        StyleJSONParser styleJSONParser = new StyleJSONParser();
//        StyleStandard[] stylesArray = styleJSONParser.start();
//
//        ChapterJSONParser chapterJsonParser = new ChapterJSONParser();
//        Chapter[] chaptersArray = chapterJsonParser.start();
//
//        CommentsAdder commentsAdder = new CommentsAdder();
//        commentsAdder.start(stylesArray, chaptersArray);
//    }

    public static void main(String[] args) throws Exception {

    Controller controller = new Controller();
    controller.start();
    }
}
