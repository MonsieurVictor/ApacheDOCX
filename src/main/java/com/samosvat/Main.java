package com.samosvat;

import com.samosvat.diplom.CommentsAdder;
import com.samosvat.diplom.StyleProperties;
import com.samosvat.diplom.PropertiesReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        
        PropertiesReader propertiesReader = new PropertiesReader();
        ArrayList <StyleProperties> stylesArrayList = propertiesReader.start();
        CommentsAdder commentsAdder = new CommentsAdder();
        commentsAdder.start(stylesArrayList);
    }
}
