/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class DiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //User input is hard coded to simulate Web Shopping Experience
        //User output is based upon joption to simulate web prompts & form activity
        //Variables have been created for quick changes to simulation
        
        
        //user logs in or tries to place an item in the shopping cart and so is forced to log in
        Receipt receipt =new Receipt_WebShoppingCart();
        DatabaseConnection db = new DatabaseConnection_FakeDb();//also connects to db from constructor
        
        PointOfSale shoppingCart = new PointOfSale_WebShoppingCart(receipt,db);//new WebCheckOut();
        
        
        //start shopping
        shoppingCart.startTransaction("User00123");
        
        DiscountProduct[]  discountProduct = new DiscountProduct[1];
        discountProduct[0] = new DiscountProduct_Clearance();
        
        //would like to build the deviceInput / deviceOutput to handle this
        shoppingCart.addLineItem("product1", 2, discountProduct);
        shoppingCart.addLineItem("procuct2", 4, discountProduct);
        
        //testing
        //Create a product :: Simulates the user's click on an item image to add to shoppingCart
        
        
        //Product product=new Product_AnyProduct("product1",db, discountProduct);//Testing
        
        
       // product.lookUpProductRecordInDatabase("product1");
        
    }//close main
}//close strategy
