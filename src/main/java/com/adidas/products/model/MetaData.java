package com.adidas.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent meta_data from the product JSON.
 */
@JsonSerialize
@JsonPropertyOrder({ "page_title", "site_name", "description", "keywords", "canonical" })
public class MetaData {

    @JsonProperty("page_title")
    private String pageTitle;

    @JsonProperty("site_name")
    private String siteName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("keywords")
    private String keywords;

    @JsonProperty("canonical")
    private String canonical;

    @JsonProperty("page_title")
    public String getPageTitle() {
        return pageTitle;
    }

    @JsonProperty("page_title")
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @JsonProperty("site_name")
    public String getSiteName() {
        return siteName;
    }

    @JsonProperty("site_name")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("canonical")
    public String getCanonical() {
        return canonical;
    }

    @JsonProperty("canonical")
    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    @Override
    public String toString() {
        return String.format("{ MetaData=%s }", pageTitle, siteName, description, keywords, canonical);
    }

}