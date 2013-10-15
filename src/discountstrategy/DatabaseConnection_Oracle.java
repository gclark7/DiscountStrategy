/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * This class is here to show the DIP ability to build classes upon interfaces that are independent of details
 * This could easily be designed to establish a real database connection
 * It could then replace the fakedatabase that is being called...No Classes would need to be recoded in order to work
 * 
 * @author gcDataTechnology
 */
public class DatabaseConnection_Oracle implements DatabaseConnection{

    @Override
    public void connectToDatabase(String connectionPath, String databaseIdentification) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] readData(String table, String recordID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DiscountProduct[] lookUpProductDiscount(String productID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeData(String[] data, String table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disconnectConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
