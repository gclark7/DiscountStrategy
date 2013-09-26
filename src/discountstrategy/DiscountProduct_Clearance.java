/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class DiscountProduct_Clearance implements DiscountProduct{
    private double discountRate;
    
    public DiscountProduct_Clearance(double discountRate){
        this.discountRate=discountRate;
    }
    
    @Override
    public double reducePrice(double amountToDiscount, double discountRate) {
         return amountToDiscount*discountRate;
    }
    
    public double reducePrice(double amountToDiscount){
        return amountToDiscount * discountRate;
    }
}
