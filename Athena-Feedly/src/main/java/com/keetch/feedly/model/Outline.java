package com.keetch.feedly.model;

/**
 * Created by keetchc on 29/09/2014.
 */
public class Outline {

    private String text;
    private String xmlURL;
    private String type;


    public Outline(String text, String xmlURL) {
        this.text = text;
        this.xmlURL = xmlURL;
    }

    public Outline() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getXmlURL() {
        return xmlURL;
    }

    public void setXmlURL(String xmlURL) {
        this.xmlURL = xmlURL;
    }


    @Override
    public String toString() {
        return "Outline{" +
                "text='" + text + '\'' +
                ", xmlURL='" + xmlURL + '\'' +
                '}';
    }


}
