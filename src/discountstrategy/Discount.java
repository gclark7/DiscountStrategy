/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface Discount {
    //applies discount to SaleAmounts or Product Unit Prices
     public abstract double reducePrice(double amountToDiscount, double discountRate);
     
}
