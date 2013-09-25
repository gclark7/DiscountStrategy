/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface Customer {
    public abstract void accessCustomerAccount(String customerID);//logs in customer and retrieves record
    public abstract void setCustomerRecord(String[] record);//sets variable to database values
    public abstract String[] getCustomerRecord();//gets customer variable
        
}
