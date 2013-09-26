/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * 
 * Simulates a ficticious Wisconsin sales tax & Waukesha County tax
 * Not going any bigger than this at this time.
 *
 * @author gcDataTechnology
 */
public class Tax_WI implements Tax{
    
    private double WAUK_TAX_RATE=0.006;
    private double WI_TAX_RATE=0.051;
    
    @Override
    public double taxTheSale(double saleAmount) {
        double tax=0.00;
        tax=saleAmount*WI_TAX_RATE;
        tax+=waukeshaCountyTax(saleAmount);
        
        
        return tax;
    }
    
    private double waukeshaCountyTax(double taxableAmount){
        return taxableAmount*WAUK_TAX_RATE;
    }
    
   
}
