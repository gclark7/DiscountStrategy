/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * The line item interface is provided to ensure extension and flexibility in the future
 * I cannot think of another type of line item that could be used, however I did want 
 * to avoid issues in the future if one ever needed to be added
 * 
 * @author gcDataTechnology
 */
public interface LineItem {
    public abstract Product getLineItem();
    public abstract String[] getProductRecord();
    public abstract void setLineItem(Product product, int qty);//will delegate to Product to return a Product
    public abstract void setItemQuantity(int qty);//need this to adjust during runtime
    
    public abstract int getItemQuantity();//need this to update displays if qty is adjusted
    public abstract double getLineItemCost();
    
}
