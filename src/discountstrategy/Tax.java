/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * The Tax is an interface to handle any and all taxes associated with the sale
 * Each Tax_Class will define it's own sales tax...
 * Each Tax_Class could be a State that implements multiple counties or looksUp a database 
 * 
 * Tax_WI will simulate Wisconsin tax & Waukesha County tax rates
 * 
 * @author gcDataTechnology
 */
public interface Tax {
    
    public abstract double taxTheSale(double saleAmount);    
    
}
