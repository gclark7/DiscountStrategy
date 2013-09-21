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
        PointOfSale shoppingCart = new PointOfSale_WebShoppingCart(receipt);//new WebCheckOut();
        
        //start shopping
        shoppingCart.startTransaction("User00123");
        
        //would like to build the deviceInput / deviceOutput to handle this
        shoppingCart.addLineItem("product1", 2);
        shoppingCart.addLineItem("procuct2", 4);
        
        
        
        
    }//close main
}//close strategy
