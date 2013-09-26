/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * In this project the driver simulates user input from a website
 * To do that it creates the PointOfSale, logs in a user and receives 2 products
 * The driver then simulates the user clicking "check out" & prints the receipt
 * 
 * @author gcDataTechnology
 */
public class DiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The following code simulates a user shopping on a web page & clicking checkout
        //User input is hard coded per instruction from Jim - since we do not yet know JFrame & GUI
       
        
        //creates the PointOfSale -- Would be a website normally
        PointOfSale shoppingCart = new PointOfSale_WebShoppingCart();//new WebCheckOut();
        
        //User logs in with credentials
        shoppingCart.startTransaction("c014852");
        
        //User starts shopping -- typically this would be "add item to shoppingCart" buttons
        shoppingCart.addLineItem("product1", 2);
        shoppingCart.addLineItem("product2", 4);
        
        //user Checks Out
        shoppingCart.checkOut();
        
        
        
        
        
        //testing
        //Create a product :: Simulates the user's click on an item image to add to shoppingCart
        
        
        //Product product=new Product_AnyProduct("product1",db);//Testing
        
        //System.out.println(db.lookUpProductDiscount("product1"));
        
       // product.lookUpProductRecordInDatabase("product1");
        
    }//close main
}//close strategy
