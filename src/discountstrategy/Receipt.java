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
    
    
    public abstract void removeLineItem(LineItem lineItem);
    public abstract void addLineItem();
    public abstract void writeReceipt();
    
}
