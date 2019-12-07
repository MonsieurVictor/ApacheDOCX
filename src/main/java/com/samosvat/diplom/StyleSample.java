package com.samosvat.diplom;

public class StyleSample {
    StyleSample[] styleSample;

    public void setStyleName(String styleName) {
        this.styleName = styleName;
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

    private String styleName;
    private String fontName;
    private int fontHeight;
    private boolean isBold;

    StyleSample(String styleName, String fontName, int fontHeight, boolean isBold) {
        this.styleName = styleName;
        this.fontName = fontName;
        this.fontHeight = fontHeight;
        this.isBold = isBold;
    }

    public String getStyleName() {return styleName;}
    public String getFontName() {return fontName;}
    public int getFontHeight() {return fontHeight;}
    public boolean isBold() {return isBold;}
}