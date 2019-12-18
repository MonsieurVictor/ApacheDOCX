package com.samosvat.diplom;

public class StyleStandard {
    StyleStandard[] styleStandard;


    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontHeight(int fontHeight) {
        this.fontHeight = fontHeight;
    }

    public void setBold(boolean isBold) {
        this.isBold = isBold;
    }

    public void setItalic(boolean isItalic) {
        this.isItalic = isItalic;
    }

    private String styleID;
    private String fontName;
    private int fontHeight;
    private boolean isBold;
    private boolean isItalic;

    StyleStandard(String styleID, String fontName, int fontHeight, boolean isBold, boolean isItalic) {
        this.styleID = styleID;
        this.fontName = fontName;
        this.fontHeight = fontHeight;
        this.isBold = isBold;
        this.isItalic = isItalic;

    }

    public String getStyleID() {return styleID;}
    public String getFontName() {return fontName;}
    public int getFontHeight() {return fontHeight;}
    public boolean isBold() {return isBold;}
    public boolean isItalic() {
        return isItalic;
    }
}