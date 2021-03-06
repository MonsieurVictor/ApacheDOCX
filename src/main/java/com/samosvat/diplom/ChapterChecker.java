package com.samosvat.diplom;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ChapterChecker {

    Chapter[] chaptersArray;
    XWPFParagraph paragraph;

    public String checkChapter(XWPFParagraph paragraph, Chapter[] chaptersArray){
        this.chaptersArray = chaptersArray;
        this.paragraph = paragraph;
        int j;
        String paragraphText = paragraph.getText();
        if (paragraphText.isEmpty()) return null;
        String currentKeyWord = "";
        for (int i = 0; i < chaptersArray.length; i++) {
            for (j = 0; j < chaptersArray[i].keyWords.length; j++) {
                currentKeyWord = chaptersArray[i].keyWords[j];
                if(paragraphText.contains(chaptersArray[i].keyWords[j])){
                    System.out.println("true " + paragraphText + " contains " + chaptersArray[i].keyWords[j]);
                    System.out.println("верно!!!");
                    return "верно!";
                }
            }   System.out.println("i= " +  i + " j= "+  j + " false paragraphText " + paragraphText + " currentKeyWord " + currentKeyWord);
            return "i= " +  i + " j= "+  j + " false paragraphText " + paragraphText + " currentKeyWord " + currentKeyWord;
        }
        System.out.println("false all");
        return "false all";
    }

    public ChapterChecker(Chapter[] chaptersArray){
        this.chaptersArray = chaptersArray;
    }


}
