package org.swchalu.retrofitexample.model;

/**
 * Created by swc12 on 2016/5/23 0023.
 */
public class SZTCallback {
    //"balance_time":"2016-05-20 18:22:28","card_balance":"80.86元","card_number":361638711,"card_validity":"2044-08-09","current_time":"2016-05-23 10:02:39"
    private String balance_time;
    private String card_balance;
    private String card_number;
    private String card_validity;
    private String current_time;

    public String getBalance_time() {
        return balance_time;
    }

    public void setBalance_time(String balance_time) {
        this.balance_time = balance_time;
    }

    public String getCard_balance() {
        return card_balance;
    }

    public void setCard_balance(String card_balance) {
        this.card_balance = card_balance;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_validity() {
        return card_validity;
    }

    public void setCard_validity(String card_validity) {
        this.card_validity = card_validity;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("SZTCallback[ ");
        stringBuffer.append("balance_time=" + getBalance_time() + "; ");
        stringBuffer.append("card_balance=" + getCard_balance() + "; ");
        stringBuffer.append("card_number=" + getCard_number() + "; ");
        stringBuffer.append("card_validity=" + getCard_validity() + "; ");
        stringBuffer.append("current_time=" + getCurrent_time());
        stringBuffer.append(" ]");
        return stringBuffer.toString();
        //"balance_time":"2016-05-20 18:22:28","card_balance":"80.86元","card_number":361638711,"card_validity":"2044-08-09","current_time":"2016-05-23 10:02:39"
    }
}
