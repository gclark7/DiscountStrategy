/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */


public class PointOfSale_WebShoppingCart implements PointOfSale{
    
     Receipt receipt;
    public PointOfSale_WebShoppingCart(Receipt receipt){
        this.receipt=receipt;
    }
    
    @Override
    public void startTransaction(String customerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void addLineItem(String productID, int qty){
        
    }
    
    
    
}