/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This is modeled after simple database connections from PHP & MySQL -- less admin permissions and such
 * Because arrays are same data type only, readData returns Product information stored in "tables"
 * lookUpProductDiscount() was developed to retrieve the Product Discount stored in another array "tableProductDiscounts"
 * 
 * any number of real methods could be built: timedOut, callStoredProcedure...
 * 
 * @author gcDataTechnology
 */
public interface DatabaseConnection {
    
    public abstract void connectToDatabase(String connectionPath, String databaseIdentification);
    public abstract String[] readData(String table, String recordID);
    public abstract DiscountProduct[] lookUpProductDiscount(String productID);
    public abstract void writeData(String[] data, String table);
    public abstract void disconnectConnection();
    public abstract boolean isConnected();
}
