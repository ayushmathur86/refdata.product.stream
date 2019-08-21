package com.adidas.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent product_description from the product JSON.
 */
@JsonSerialize
@JsonPropertyOrder({ "title", "subtitle", "text" })
public class ProductDescription {

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("text")
    private String text;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("{ ProductDescription=%s }", title, subtitle, text);
    }

}