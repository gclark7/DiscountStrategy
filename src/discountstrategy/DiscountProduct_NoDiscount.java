/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class DiscountProduct_NoDiscount implements DiscountProduct{

    @Override
    public double reducePrice(double amountToDiscount, double discountRate) {
         return 0;
    }
    
}
