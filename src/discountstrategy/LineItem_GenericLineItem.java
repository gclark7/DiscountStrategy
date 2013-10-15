/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This is the generic line item...It's purpose is to provide line item details
 * to the receipt.
 * 
 * It is the only line item I can think to need, however there is opportunity to create others if necessary
 * Because this class is built upon abstraction, another line item will not break the receipt
 * @author gcDataTechnology
 */
public class LineItem_GenericLineItem implements LineItem{
    private final String MSG_ERR_NULL="Null value";
    private int productQty;
    private Product product;

    public LineItem_GenericLineItem(Product product, int qty){
        //error handling in setLineItem method
        setLineItem(product, qty);
    }
    
    /**
     * 
     * returns the Product 
     * @return 
     */
    @Override 
    public Product getLineItem(){
        return product;
    }
    
    /**
     * 
     * Delegates to the Product to return product details
     * 
     * @return 
     */
    @Override
    public String[] getProductRecord() {
       return product.getProductRecord();
    }
    
    /**
     * 
     * sets the private variables product and productQty
     * 
     * @param product
     * @param qty 
     */
    @Override
    public void setLineItem(Product product, int qty) {//delegate to Product to return a Product
         if(product==null || qty<=0){
            throw new UnsupportedOperationException(MSG_ERR_NULL);
        } else{
             
             this.product=product;
             productQty=qty;
            
             
        }
        
        
    }
    
    /***
     * 
     * public setter for quantity
     * @param qty 
     */
    @Override
    public void setItemQuantity(int qty) {
        if(qty<=0){
            throw new UnsupportedOperationException(MSG_ERR_NULL); //To change body of generated methods, choose Tools | Templates.
        }else{productQty=qty;}
        
    }
    /**
     * 
     * returns the quantity for associated product
     * @return 
     */
    @Override
    public int getItemQuantity() {
        return productQty;
    }

  /**
   * 
   * delegates to the Product to retrieve its cost
   * returns  calculated cost according to quantity
   * @return 
   */
    @Override
    public double getLineItemCost() {
        return product.getProductPrice()*productQty;
    }
    
   
    
}
