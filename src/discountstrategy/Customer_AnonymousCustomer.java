/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class Customer_AnonymousCustomer implements Customer{

  private final String NOT_READY="You Should have made an account...Not supported yet";
    
  private final String[] record={"As an anonymouns customer you will have to fill in all shipping info\n" +
          "Have a nice day"};
  
    @Override
    public void accessCustomerAccount(String customerID) {
        throw new UnsupportedOperationException(NOT_READY); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCustomerRecord(String[] record) {
        throw new UnsupportedOperationException(NOT_READY); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getCustomerRecord() {
        return record;
    }
    
}
