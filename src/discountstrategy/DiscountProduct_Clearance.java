/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Example of a discount used by products
 * This is a working discount
 * Its discount rate is set at initialization in the fakedatabase
 * Each product and each discount is able to have a unique discount rate
 * 
 * @author gcDataTechnology
 */
public class DiscountProduct_Clearance implements DiscountProduct{
    private double discountRate;
    
    
    public DiscountProduct_Clearance(double discountRate){
        this.discountRate=discountRate;
    }
    
    /**
     * 
     * Discounts are calculated and returns the amount to charge
     * this method uses a rate as a parameter
     * @param amountToDiscount
     * @param discountRate
     * @return 
     */
    @Override
    public double reducePrice(double amountToDiscount, double discountRate) {
         return amountToDiscount*discountRate;
    }
    /**
     * Discount is calculated and returns the amount to charge
     * Uses a set discount rate set during object initialization
     * 
     * @param amountToDiscount
     * @return 
     */
    @Override
    public double reducePrice(double amountToDiscount){
        return amountToDiscount * discountRate;
    }
}
