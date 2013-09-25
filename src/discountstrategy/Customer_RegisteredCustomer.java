/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class Customer_RegisteredCustomer implements Customer{
    private final String MSG_ERR_USER="Customer ID is unrecoginzed";
    private final String MSG_ERR_NULL="Null Values";
    private final String DATA_TABLE="tableCustomers";
    private DatabaseConnection db;
    private String[] customerRecord;
    private String customerID="";
    
    public Customer_RegisteredCustomer(String customerID, DatabaseConnection db){
        this.db=db;
        this.customerID=customerID;
        accessCustomerAccount(customerID);
    }
    
    @Override
    public void accessCustomerAccount(String customerID) {//considered placing password here as well
           
        if(!isCustomer(customerID)){//error handling is in isCustomer()
            throw new UnsupportedOperationException(MSG_ERR_USER); //To change body of generated methods, choose Tools | Templates.
        }else{
            setCustomerRecord(db.readData(DATA_TABLE, customerID));
        }
        
        
    }
    
    private boolean isCustomer(String customerID){
        boolean isCustomer=false;
        
        if(customerID==null||customerID.length()==0){
        throw new UnsupportedOperationException(MSG_ERR_USER); //To change body of generated methods, choose Tools | Templates.
        }else{
            if(db.readData(DATA_TABLE, customerID)!=null||db.readData(DATA_TABLE, customerID).length!=0){
                isCustomer=true;
            }
        }
        
        return isCustomer;
    }

    @Override
    public void setCustomerRecord(String[] record) {
        if(record==null||record.length==0){
        throw new UnsupportedOperationException(MSG_ERR_NULL); //To change body of generated methods, choose Tools | Templates.
        }else{
            customerRecord=record;
        }
    }

    @Override
    public String[] getCustomerRecord() {
        return customerRecord;
    }
    
}
