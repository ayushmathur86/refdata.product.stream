package com.adidas.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class to represent pricing_information from the product JSON.
 */
@JsonSerialize
@JsonPropertyOrder({ "standard_price", "standard_price_no_vat", "currentPrice" })
public class PricingInformation {

    @JsonProperty("standard_price")
    private double standardPrice;

    @JsonProperty("standard_price_no_vat")
    private double standardPriceNoVat;

    @JsonProperty("currentPrice")
    private double currentPrice;

    @JsonProperty("standard_price")
    public double getStandardPrice() {
        return standardPrice;
    }

    @JsonProperty("standard_price")
    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    @JsonProperty("standard_price_no_vat")
    public double getStandardPriceNoVat() {
        return standardPriceNoVat;
    }

    @JsonProperty("standard_price_no_vat")
    public void setStandardPriceNoVat(double standardPriceNoVat) {
        this.standardPriceNoVat = standardPriceNoVat;
    }

    @JsonProperty("currentPrice")
    public double getCurrentPrice() {
        return currentPrice;
    }

    @JsonProperty("currentPrice")
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return String.format("{ PricingInformation=%s }", standardPrice, standardPriceNoVat, currentPrice);
    }

}
