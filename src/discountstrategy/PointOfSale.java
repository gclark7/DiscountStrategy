/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface PointOfSale {
    public abstract void startTransaction(String customerID);
    public abstract void addLineItem(String productID, int qty, DiscountProduct[] discount);
    public abstract void checkOut();
    
}
