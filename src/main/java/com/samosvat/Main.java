package com.samosvat;

import com.samosvat.diplom.*;

public class Main {
    public static void main(String[] args) throws Exception {

        StyleJSONParser styleJSONParser = new StyleJSONParser();
        StyleSample[] stylesArray = styleJSONParser.start();

        ChapterJSONParser chapterJsonParser = new ChapterJSONParser();
        Chapter[] chaptersArray = chapterJsonParser.start();

        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArray, chaptersArray);
    }
}
