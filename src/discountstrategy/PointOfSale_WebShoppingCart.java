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
    private final String MSG_ERR_NULL="NULL Value";
     Receipt receipt;
     
    public PointOfSale_WebShoppingCart(Receipt receipt){
        this.receipt=receipt;
    }
    
    @Override
    public void startTransaction(String customerID) {
        if(customerID==null){
            throw new UnsupportedOperationException(MSG_ERR_NULL + customerID.getClass()); //To change body of generated methods, choose Tools | Templates.
        }else{
            
        }
        
    }
    
    @Override
    public void addLineItem(String productID, int qty){
        
    }
    
    
    
}
