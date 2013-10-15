/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class ProductFactory {
    
    private static ProductFactory pFactoryInstance;
    
    public static enum InventoryItems{PRODUCT1,PRODUCT2,PRODUCT3}
    
    public static ProductFactory getProductFactoryInstance(){
        if(pFactoryInstance==null){
            pFactoryInstance=new ProductFactory();
        }
        return pFactoryInstance;
    }
    
    /**
     * private to force singleton
     */
    private ProductFactory(){
        
    }
    
    public Product_AnyProduct createProduct(InventoryItems item, DatabaseConnection db){
        
        return new Product_AnyProduct(item.name(),db);
    }
    
}
