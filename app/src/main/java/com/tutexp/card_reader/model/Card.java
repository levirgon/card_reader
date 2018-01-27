package com.tutexp.card_reader.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by noushad on 1/27/18.
 */
@Entity
public class Card {

    @Id
    private long id;
    private String bankName;
    private String productName;
    private String cardType;
    private String currency;
    private String existingBin;

    public Card() {
    }

    public Card(String bankName, String productName, String cardType, String currency, String existingBin) {
        this.bankName = bankName;
        this.productName = productName;
        this.cardType = cardType;
        this.currency = currency;
        this.existingBin = existingBin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExistingBin() {
        return existingBin;
    }

    public void setExistingBin(String existingBin) {
        this.existingBin = existingBin;
    }
}
