/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */

public interface Receipt {
    
    public abstract void setCustomer(String customerID);
    public abstract void removeLineItem(int i);
    public abstract void addLineItem(Product product, int qty);
    public abstract String timeStamp();
    public abstract void printReceipt();
    
    
}
