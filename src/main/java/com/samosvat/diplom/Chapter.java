package com.samosvat.diplom;

public class Chapter {
    Chapter [] chapter;
    String chapter_name;
    String heading_name;
    String [] keywords;
    String [] stylesAllowed;
    int paragraphsCount;
    int symbolsCount;

    public Chapter(String chapter_name,
                   String heading_name,
                   String[] keywords,
                   String[] stylesAllowed,
                   int paragraphsCount,
                   int symbolsCount) {
        this.chapter_name = chapter_name;
        this.heading_name = heading_name;
        this.keywords = keywords;
        this.stylesAllowed = stylesAllowed;
        this.paragraphsCount = paragraphsCount;
        this.symbolsCount = symbolsCount;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getHeading_name() {
        return heading_name;
    }

    public void setHeading_name(String heading_name) {
        this.heading_name = heading_name;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getStylesAllowed() {
        return stylesAllowed;
    }

    public void setStylesAllowed(String[] stylesAllowed) {
        this.stylesAllowed = stylesAllowed;
    }

    public int getParagraphsCount() {
        return paragraphsCount;
    }

    public void setParagraphsCount(int paragraphsCount) {
        this.paragraphsCount = paragraphsCount;
    }

    public int getSymbolsCount() {
        return symbolsCount;
    }

    public void setSymbolsCount(int symbolsCount) {
        this.symbolsCount = symbolsCount;
    }
}

