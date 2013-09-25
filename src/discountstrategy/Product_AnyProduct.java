/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * this class looks up any product
 * @author gcDataTechnology
 */
public class Product_AnyProduct implements Product{
    private String MSG_ERR_NULL="NULL";
    
    private DiscountProduct[] productDiscounts;
    private String[] productRecord;
    private DatabaseConnection db;
    private final String PRODUCT_TABLE="tableProducts";
    
    //constructor
    public Product_AnyProduct(String productID, DatabaseConnection db){
        //null error handling to be built here
        this.db=db;
        productDiscounts=new DiscountProduct[0];
        productRecord=new String[0];
        setProductRecord(lookUpProductRecordInDatabase(productID));
        setProductDiscounts(db.lookUpProductDiscount(productID));
    }
    
    @Override
    public DiscountProduct[] getProductDiscount() {
        return this.productDiscounts;
    }

    @Override
    public void addAnotherProductDiscount(DiscountProduct discount) {
        if(discount == null){
            throw new UnsupportedOperationException(MSG_ERR_NULL + discount.getClass()); //To change body of generated methods, choose Tools | Templates.
        }else{
        int indexStart=0;
        int newSize=this.productDiscounts.length + 1;
        DiscountProduct[] temp = new DiscountProduct[newSize];
        int elementIndex = temp.length-1;
        System.arraycopy(this.productDiscounts, indexStart, temp, indexStart, elementIndex);
        temp[elementIndex]=discount;
        this.productDiscounts=temp;
        }
        
        
    }
    
    @Override
    public void setProductDiscounts(DiscountProduct[] discount){
        for(DiscountProduct d:discount){
            if(d==null){
                System.out.println("Line55 Product_AnyProduct " + discount);
                throw new UnsupportedOperationException(MSG_ERR_NULL + discount.getClass());
            }
        }
        
        productDiscounts=discount;
        
    }

    @Override
    public String[] getProductRecord() {
        return productRecord;
    }

    @Override
    public void setProductRecord(String[] recordDetails) {
        //error handling here
        //throw an exception on error
        
        productRecord=recordDetails;
        
    }

    @Override
    public void updateDatabaseRecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] lookUpProductRecordInDatabase(String productID) {
        
       if(productID==null){
           throw new UnsupportedOperationException(MSG_ERR_NULL + productID.getClass()); //To change body of generated methods, choose Tools | Templates.
       }else{
           //enter database information
           return db.readData(PRODUCT_TABLE,productID);
       }
    }
    
    
    
    
    
}
