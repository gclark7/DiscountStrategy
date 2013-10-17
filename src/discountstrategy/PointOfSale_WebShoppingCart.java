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
    private Receipt receipt;
    private DatabaseConnection db;
     
     
     
    public PointOfSale_WebShoppingCart(Receipt receipt, DatabaseConnection db){
        this.receipt=receipt;
        this.db=db;
    }
    
    public PointOfSale_WebShoppingCart(){
        db = new DatabaseConnection_FakeDb();
        receipt =new Receipt_WebShoppingCart(db);
        
    }
    
    @Override
    public void startTransaction(String customerID) {
        if(customerID==null||customerID.length()==0){
            throw new UnsupportedOperationException(MSG_ERR_NULL + customerID.getClass()); //To change body of generated methods, choose Tools | Templates.
        }else{
          receipt.setCustomer(customerID);
        }
        
    }
    
    @Override
    public void addLineItem(String productID, int qty){
         //original product creation commented out 10/17/2013
        //Product p = new Product_AnyProduct(productID, db);
        
        Product p;//added 10/17/2013
        //10/15/2013 Adding lab work Factory
        ProductFactory pf = ProductFactory.getProductFactoryInstance();
        p=pf.createProduct(productID, db);//added 10/17/2013
        
       
        
         //NOT NEEDED ***NEVER USED IN ORIGINAL APP       //db.readData("productsTable", productID);
        
        receipt.addLineItem(p,qty);
    }
    
    @Override
    public void checkOut(){
        receipt.printReceipt();
    }
    
    
}
