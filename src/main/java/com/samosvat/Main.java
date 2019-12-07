package com.samosvat;

import com.samosvat.diplom.*;

public class Main {
    public static void main(String[] args) throws Exception {


         
        StyleSampleReader styleSampleReader = new StyleSampleReader();
        StyleSample[] stylesArray = styleSampleReader.start();

        JSONParser jsonParser = new JSONParser();
        Chapter[] chaptersArray = jsonParser.start();

        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArray, chaptersArray);
    }
}
