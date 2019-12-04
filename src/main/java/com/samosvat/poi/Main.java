package com.samosvat.poi;

import com.samosvat.poi.diplom.CommentsAdder;
import com.samosvat.poi.diplom.PropertiesReader;
import com.samosvat.poi.diplom.StyleProperties;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        ArrayList <StyleProperties> stylesArrayList = propertiesReader.start();

        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArrayList);


    }
}
