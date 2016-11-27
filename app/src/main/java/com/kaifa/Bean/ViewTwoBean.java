package com.kaifa.Bean;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/14 20:28
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class ViewTwoBean {
    private String text;
    private int  icon;
    private String firstChar;
    private int type;
    public int getIcon(){
        return icon;
    }
    public void setIcon(int icon){
        this.icon = icon;
    }
    public void setText(String text){
        this.text = text;

    }
    public String getText(){
        return text;
    }
    public String getfirstChar(){
        return firstChar;
    }
    public void setfirstChar(String firstChar){
        this.firstChar = firstChar;
    }
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
}
