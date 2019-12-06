//package com.samosvat.diplom;
//
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class VParagraph {
//    private XWPFParagraph paragraph;
//
//    public VParagraph(XWPFParagraph paragraph) {
//        this.paragraph = paragraph;
//    }
//
//    public String getStyle() {
//        return this.paragraph.getStyle();
//    }
//
//    public FontData getFontData() {
//        return null;
//    }
//
//    public String getText() {
//        this.paragraph.getParagraphText();
//    }
//
//    List<AbstractTextBlock> defaultList = getSettings();
//    Map<String, vParagraph> currentBlocksMap = new HashMap();
//
//    for(VParagraph vParagraph: vParagraphs){
//            for(AbstractTextBlock textBlock : defaultList){
//                if(textBlock.check(vParagraph){
//                    currentBlocksMap.put(textBlock.getTextBlockName(), vParagraph);
//                }
//            }
//        }
//
//    int i = 0;
//
//    for(Map.Entry<String, vParagraph entry: map.entrySet()){
//            AbstractTextBlock defaultTextBlock = defaultList.get(i);
//            if(!defaultTextBlock.getTextBlockName().equals(entry.getKey()){
//                entry.getValue().addErrorText(defaultTextBlock.getErrorText());
//            }
//            i++;
//        }
//
//    if(i < defaultList.size()){
//            for( ++i ; i < defaultList.size(); i++){
//                vParagraphs.get(vParagraphs.size - 1).addErrorText(defaultList.get(i).getErrorText);
//            }
//        }
//
//    abstract class AbstractTextBlock{
//        protected abstract String getStyleTemplate();
//        protected abstract String getTextTemplate();
//        public abstract String getTextBlockName();
//        public abstract String getErrorText();
//
//        protected boolean check(VParagraph vParagraph){
//            Pattern textPattern = Pattern.compile(getTextTemplate());
//            Matcher matcher = textPattern.matcher(vParagraph.getText());
//
//            Pattern stylePattern = Pattern.compile(getStyleTemplate());
//            Matcher matcher2 = stylePattern.matcher(vParagraph.getStyle());
//
//            return vParagraph.getStyle.equals(getStyleTemplate())
//                    && matcher.matches();
//    }
//}
//
//    class InstituteName extends AbstractTextBlock{
//        public final String INSTITUTE_NAME = "INSTITUTE_NAME";
//        private String textTemplate = "~^Брянский институт~";
//        private String styleTemplate = null;
//        private String errorText = "Before this block the Institute name block is expected"
//
//        protected String getStyleTemplate(){
//		....
//            return styleTemplate;
//        }
//        protected String getTextTemplate(){}
//        public String getTextBlockName(){
//            return INSTITUTE_NAME;
//        }
//        public String getErrorText(){
//            return errorText;
//        }
//    }
//
//    class Title extends AbstractTextBlock{
//        private String textTemplate  = "~^[a-bA-Bа-яА-Я]+(.){10;}~";
//        private String styleTemplate = "";
//    }
//
//    private class FontData {
//
//        private int fontSize () {};
//        private String FontFamily(){};
//        private String FontBoldness(){};
////        ....
//    }
//}
