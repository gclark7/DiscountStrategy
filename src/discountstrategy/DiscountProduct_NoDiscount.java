/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * This class is used to show LSP and DIP 
 * it is designed to allow for no discount on a product.  During class
 * Jim L had stated we need to have 1 discount for each product, which could be no discount
 * This can be substituted for active product discounts and not damage any functionality
 * 
 * @author gcDataTechnology
 */
public class DiscountProduct_NoDiscount implements DiscountProduct{

    @Override
    public double reducePrice(double amountToDiscount, double discountRate) {
         return 0;
    }
    
    @Override
    public double reducePrice(double amountToDiscount){
        return 0;
    }
    
}
