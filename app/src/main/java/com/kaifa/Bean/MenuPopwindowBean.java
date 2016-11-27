package com.kaifa.Bean;

/*
 * @创建者     Administrator
 * @创建时间   2016/11/13 15:06
 * @描述	      ${TODO}
 *
 * @更新者     $Author$
 * @更新时间   $Date$
 * @更新描述   ${TODO}
 */
public class MenuPopwindowBean {
    private String text;
    private int  icon;

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

}
