package com.samosvat.diplom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesReader {

    public ArrayList <StyleProperties> start () throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("styles.properties");
        properties.load(fileInputStream);
        int stylesCount = Integer.parseInt(properties.getProperty("stylesCount"));
        System.out.println("Количество стилей в файле: " + stylesCount);
        ArrayList <StyleProperties> arrayList = new ArrayList <> ();

        for (int i = 0; i< stylesCount; i++){
            String idNumber = "id_" + i;

            String styleName = properties.getProperty(idNumber);
            System.out.println(styleName);

            String fontName = properties.getProperty(idNumber + "_fontName");
            System.out.println(fontName);

            int fontHeight = Integer.parseInt(properties.getProperty(idNumber + "_fontHeight"));
            System.out.println(fontHeight);

            boolean isBold = Boolean.parseBoolean(properties.getProperty(idNumber + "_isBold"));
            System.out.println(isBold);

            System.out.println();
            arrayList.add(new StyleProperties(styleName, fontName, fontHeight, isBold));

        }
        return arrayList;
    }
}


