package uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist;

/**
 * Created by sysdevl2 on 09/05/2017.
 */

public interface Saleable {
    public String getBarcode();
    public void setBarcode(String barcode);
    public String getDescription();
    public void setDescription(String description);
    public double getRetailPrice();
    public void setRetailPrice(double retailPrice);
    public double getItemWeight();
    public void setItemWeight(double itemWeight);
}
