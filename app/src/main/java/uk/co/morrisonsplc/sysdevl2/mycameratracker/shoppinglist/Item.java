package uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist;

/**
 * Created by sysdevl2 on 09/05/2017.
 */

public class Item implements Saleable {
    private String barcode;
    private String description;
    private double retailPrice;
    private double itemWeight;

    public Item (String barcode,
                 String description,
                 double retailPrice,
                 double itemWeight){
        this.barcode = barcode;
        this.description = description;
        this.retailPrice = retailPrice;
        this.itemWeight = itemWeight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }
}
