package com.samosvat.poi.diplom;

public class StyleProperties {
    private final String styleName;
    private final String fontName;
    private final int fontHeight;
    private final boolean isBold;

    StyleProperties(String styleName, String fontName, int fontHeight, boolean isBold) {
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
