/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface LineItem {
    public abstract String[] getLineItem();
    public abstract void setLineItem(String product, int qty);//will delegate to Product to return a Product
    public abstract void setItemQuantity(int qty);//need this to adjust during runtime
    public abstract int getItemQuantity();//need this to update displays if qty is adjusted
    
}
