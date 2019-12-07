package com.samosvat.diplom;

public class StyleSample {
    StyleSample[] styleSample;

    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontHeight(int fontHeight) {
        this.fontHeight = fontHeight;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    private String styleID;
    private String fontName;
    private int fontHeight;
    private boolean isBold;

    StyleSample(String styleID, String fontName, int fontHeight, boolean isBold) {
        this.styleID = styleID;
        this.fontName = fontName;
        this.fontHeight = fontHeight;
        this.isBold = isBold;
    }

    public String getStyleID() {return styleID;}
    public String getFontName() {return fontName;}
    public int getFontHeight() {return fontHeight;}
    public boolean isBold() {return isBold;}
}