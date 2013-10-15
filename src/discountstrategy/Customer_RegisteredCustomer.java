/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This customer is operational and utilizes DIP for attribute values
 * The db connection is based upon an interface 
 * The customer Record lines up with table indices : the tables would be from views in a database
 * customer has knowledge of the column layout, but not of the connection to the database
 * 
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
    private final int INDEX_CUSTOMERID=0;
    private final int INDEX_FNAME=1;
    private final int INDEX_LNAME=2;
    private final int INDEX_ADDRESS=3;
    private final int INDEX_CITY=4;
    private final int INDEX_STATE=5;
    private final int INDEX_ZIP=6;
    
    
    public Customer_RegisteredCustomer(String customerID, DatabaseConnection db){
        this.db=db;
        this.customerID=customerID;
        accessCustomerAccount(customerID);
    }
    
    /**
     * This method fetches the customer record from the database
     * it is used to call the setter method for the private array variable customerRecord
     * 
     * @param customerID 
     */
    @Override
    public void accessCustomerAccount(String customerID) {//considered placing password here as well
           
        //if(!isCustomer(customerID)){//error handling is in isCustomer()
        if(customerID==null||customerID.length()==0){
            throw new UnsupportedOperationException(MSG_ERR_USER); //To change body of generated methods, choose Tools | Templates.
        }else{
            
            setCustomerRecord(db.readData(DATA_TABLE, customerID));
        }
        
        
    }
    /**
     * Used to check for record match in database
     * Ensures data was found
     * Can be used to ensure no connection failure during record fetch procedure
     * 
     * @param customerID
     * @return 
     */
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
    
    /**
     * This method sets the customer record 
     * private array variable customerRecord is set to its data value
     * @param record 
     */
    @Override
    public void setCustomerRecord(String[] record) {
        if(record==null||record.length==0){
        throw new UnsupportedOperationException(MSG_ERR_NULL); //To change body of generated methods, choose Tools | Templates.
        }else{
            customerRecord=record;
        }
    }
    
    /**
     * 
     * returns full customerRecord variable
     * @return 
     */
    @Override
    public String[] getCustomerRecord() {
        return customerRecord;
    }
    
    /**
     * 
     * returns customer full name - first then last
     * @return 
     */
    @Override
    public String getCustomerName() {
        return customerRecord[1]+ " " + customerRecord[2];
    }
    /**
     * 
     * returns customer shipping information including name - first then last
     * @return 
     */
    @Override
    public String getCustomerShippingInformation() {
        String shipping=getCustomerName() + "\n";
            for(int i=INDEX_ADDRESS;i<=INDEX_ZIP;i++){
                shipping+=customerRecord[i] + "\n";
            }
        return shipping;
    }
    
}
