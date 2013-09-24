/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface Product {
    
    public abstract DiscountProduct[] getProductDiscount();
    public abstract void setProductDiscounts(DiscountProduct[] discount);
    public abstract void addAnotherProductDiscount(DiscountProduct discount);
    public abstract String[] getProductRecord();//returns record stored in Product Object
    public abstract String[] lookUpProductRecordInDatabase(String productID);
    public abstract void setProductRecord(String[] recordDetails);//pulls from database
    public abstract void updateDatabaseRecord();//intended to take the current Product Object settings & write it to database
    
}
