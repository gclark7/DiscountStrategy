/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class Receipt_WebShoppingCart implements Receipt{
    private final String MSG_ERR_NULL="Null value";
    private LineItem lineItem;
    
    
    public Receipt_WebShoppingCart(){
        lineItem =new LineItem_GenericLineItem();
                
    }
    
    @Override
    public void removeLineItem(int i) {
       
       lineItem.removeLineItem(i);//original product array in LineItem
        
    }

    @Override
    public void addLineItem(Product product, int qty) {
        
        
        lineItem.setLineItem(product, qty);
    }

    @Override
    public void printReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
