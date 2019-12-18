package com.samosvat.diplom;

import java.io.IOException;

public class Controller {

    public void start(){

        GUI gui = new GUI();
        gui.startDraw();

        StyleJSONParser styleJSONParser = new StyleJSONParser();
        StyleStandard[] stylesArray = new StyleStandard[0];
        try {
            stylesArray = styleJSONParser.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChapterJSONParser chapterJsonParser = new ChapterJSONParser();
        Chapter[] chaptersArray = new Chapter[0];
        try {
            chaptersArray = chapterJsonParser.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArray, chaptersArray);


    }
}
