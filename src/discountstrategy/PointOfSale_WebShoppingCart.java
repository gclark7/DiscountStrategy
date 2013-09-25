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
     DatabaseConnection db;
     
     
     
    public PointOfSale_WebShoppingCart(Receipt receipt, DatabaseConnection db){
        this.receipt=receipt;
        this.db=db;
    }
    
    public PointOfSale_WebShoppingCart(){
        receipt =new Receipt_WebShoppingCart();
        db = new DatabaseConnection_FakeDb();
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
        Product p = new Product_AnyProduct(productID, db);
                //db.readData("productsTable", productID);
        
        receipt.addLineItem(p,qty);
    }
    
    @Override
    public void checkOut(){
        
    }
    
    
}
