package ua.en.kosse.oksana.tommy;

public class Company {
    private String firmName;
    private int amountShare;
    private double priceShare;


    public Company(String firmName, int amountShare, double priceShare) {
        this.firmName = firmName;
        this.amountShare = amountShare;
        this.priceShare = priceShare;
    }

    synchronized public String getFirmName() {
        return firmName;
    }

    synchronized public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    synchronized public int getAmountShare() {
        return amountShare;
    }

    synchronized public void setAmountShare(int amountShare) {
        this.amountShare = amountShare;
    }

    synchronized public double getPriceShare() {
        return priceShare;
    }

    synchronized public void setPriceShare(double priceShare) {
        this.priceShare = priceShare;
    }
}


