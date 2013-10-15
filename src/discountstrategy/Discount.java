/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * This is the interface for all discounts
 * 2 types of discounts have extended this interface - sale discount and product discount
 * Product discount is a requirement which requires a product to have 1 discount
 * 
 * This has been designed to show flexibility that a discount can be designed for a specific purpose
 * and still be flexible enough to be substituted without the need for recoding.
 * 
 * In this simulation the DiscountProduct is the working discount and is associated with Products
 * Any type of DiscountProduct would be accepted by Product as a viable discount
 * Remember the fakedatabase is where the product discount is initialized to simulate related tables
 * Products receive their discount by looking it up in the fake database
 * 
 * 
 * @author gcDataTechnology
 */
public interface Discount {
    //applies discount to SaleAmounts or Product Unit Prices
     public abstract double reducePrice(double amountToDiscount, double discountRate);
     public abstract double reducePrice(double amountToDiscount);
}
