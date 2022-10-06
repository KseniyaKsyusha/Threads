package ua.en.kosse.oksana.tommy;

public class Buyers {
    private String buyerName;
    public Company comp;

    public Buyers(String buyerName, Company comp) {
        this.buyerName = buyerName;
        this.comp = comp;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

}
