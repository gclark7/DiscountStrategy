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
        String userID="User00123";
        Receipt receipt =new WebReceipt();
        PointOfSale shoppingCart = new ShoppingCart();//new WebCheckOut();
        shoppingCart.startTransaction(userID);
        
        
        
        
    }//close main
}//close strategy
