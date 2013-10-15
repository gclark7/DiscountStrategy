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
 * ALL Classes are designed to implement interfaces
 * This application is flexible in many ways as its composition is based upon abstraction
 * 
 * Substitute Classes have been provided but may not be functioning at this time.
 * The intention is to show how another Class can be substituted for a current Class according
 * to the Liskov Substitution Principle.
 * 
 * DRY, DIP and LSP have all been used to create a flexible, non-fragile & portable application
 * Principle of least knowledge has been widely used in all Classes, and most evident in the higher level classes
 * Even the low level classes have some ambiguity to their functions in that they do not know what type of 
 * database they connect to, but only that they do connect and have an ordered layout for data retrieval.
 * 
 * This application has been designed with the goal of being able to work with a register or a website.
 * The requirement was to simulate a web transaction.
 * 
 *
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
       
        //10/15/2013 Adding lab work Factory
        ProductFactory pf = ProductFactory.getProductFactoryInstance();
        
        
        
        //creates the PointOfSale -- Would be a website normally
        PointOfSale shoppingCart = new PointOfSale_WebShoppingCart();//new WebCheckOut();
        
        //User logs in with credentials
        shoppingCart.startTransaction("c014852");
        
        //User starts shopping -- typically this would be "add item to shoppingCart" buttons
        shoppingCart.addLineItem("PRODUCT1", 2);
        shoppingCart.addLineItem("PRODUCT2", 4);
       
        
        //user Checks Out
        shoppingCart.checkOut();
        
        
        
        
        
        //testing
        //Create a product :: Simulates the user's click on an item image to add to shoppingCart
        
        
        //Product product=new Product_AnyProduct("product1",db);//Testing
        
        //System.out.println(db.lookUpProductDiscount("product1"));
        
       // product.lookUpProductRecordInDatabase("product1");
        
    }//close main
}//close strategy
