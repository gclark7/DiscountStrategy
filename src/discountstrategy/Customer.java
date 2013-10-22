/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * Customers do not need to register, but would have to provide required information
 * Such information includes shipping, billing & verification
 * This interface allows for multiple types of customers to be created to fit specified profiles
 * The Class in use is a RegisteredCustomer - They will be listed in the database and return proper information
 * A web customer would be prompted for customer identification
 * A register would read customer information from coupons or charge cards or cashier entry
 * 
 * @author gcDataTechnology
 */
public interface Customer {
    
    public abstract void accessCustomerAccount(String customerID);//logs in customer and retrieves record
    public abstract void setCustomerRecord(String[] record);//sets variable to database values
    public abstract String[] getCustomerRecord();//gets customer variable
    public abstract String getCustomerName();
    public abstract String getCustomerShippingInformation();
}
