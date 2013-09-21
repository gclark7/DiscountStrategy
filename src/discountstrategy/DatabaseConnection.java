/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public interface DatabaseConnection {
    
    public abstract void connectToDatabase(String connectionPath, String databaseIdentification);
    public abstract String[] readData(String table, String recordID);
    public abstract void writeData(String[] data, String table);
    public abstract void disconnectConnection();
    public abstract boolean isConnected();
}
