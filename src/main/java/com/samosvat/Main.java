package com.samosvat;

import com.samosvat.diplom.*;

public class Main {
    public static void main(String[] args) throws Exception {

        StyleSampleParser styleSampleParser = new StyleSampleParser();
        StyleSample[] stylesArray = styleSampleParser.start();

        JSONParser jsonParser = new JSONParser();
        Chapter[] chaptersArray = jsonParser.start();

        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArray, chaptersArray);
    }
}
