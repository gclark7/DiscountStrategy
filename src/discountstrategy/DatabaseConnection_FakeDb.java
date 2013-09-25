/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 * This is a fake database based upon the DatabaseConnection Interface 
 * It is designed to simulate the connection, disconnection of a db
 * It is designed to simulate tables of data for Products & Customers
 * The Products "table" has a relationship with a discountTable to simulate a real database
 * 
 * The tables are 2 dimensional arrays based upon several data arrays -- they populate inside the constructor
 * 
 * IN THE FUTURE connection to real relational database, data is anticipated to be retrieved through Views in the database
 * Views are in keeping with flexible, non-fragile, portable design as the 
 * base tables can be altered without damaging data results & they encapsulate real tables
 * 
 * @author gcDataTechnology
 */
public class DatabaseConnection_FakeDb implements DatabaseConnection{
    private final String MSG_ERR_CONNECTION_FAILURE="Failed to Connect to Database";
    private final String MSG_CONNECTION_SUCCESS="Connection Successfull";
    private final String dbID="db449494949PKohls";
    private final String connectionPath="https://ontheinterwebs.dbserver.Kohls.com";
    private final String MSG_ERR_TABLE="Table not found";
    private final String MSG_ERR_RECORD="Record Data Result Error";
    
    //per Jim we can hard code these in to simulate a database
    private int r=3;
    private int c=3;
    private String[] products = {"product1","product2","product3"};
    private String[] productDescriptions={"dress","pants","shirt"};
    private String[] productPrice={"100.00", "30.75", "45.34"};
    
    private String[][] tableProducts;
    private final int INDEX_PRODUCT=0;
    private final int INDEX_DESCRIPTON=1;
    private final int INDEX_PRICE=2;
    
    private String[] customerID={"c014852","c014855","c014322"};
    private String[] customerFName={"Jim","Jane","John"};
    private String[] customerLName={"Jones","Jackson","Jeeves"};
    
    private String[][] tableCustomers;
    private final int INDEX_ID=0;
    private final int INDEX_FNAME=1;
    private final int INDEX_LNAME=2;
    
    
    private DiscountProduct[][] tableProductDiscounts;
    
    private DiscountSale[] saleDiscounts={new DiscountSale_KohlsCash()};
    
    public DatabaseConnection_FakeDb(){
        connectToDatabase(connectionPath,dbID);
        tableProducts=new String[r][c];
        //populate tables
        //products
        for(int i=0;i<r;i++){
            //outer record by record
            for(int j=0;j<c;j++){
                //populate columns
               
                switch(j){
                    case INDEX_PRODUCT:tableProducts[i][j]=products[i];break;
                    case INDEX_DESCRIPTON:tableProducts[i][j]=productDescriptions[i];break;
                    case INDEX_PRICE:tableProducts[i][j]=productPrice[i];break;
                }
            }
        }//products
        
        tableCustomers=new String[r][c];
        for(int i=0;i<r;i++){
            //outer record by record
            for(int j=0;j<c;j++){
                //populate columns
                switch(j){
                    case INDEX_ID:tableCustomers[i][j]=customerID[i];break;
                    case INDEX_FNAME:tableCustomers[i][j]=customerFName[i];break;
                    case INDEX_LNAME:tableCustomers[i][j]=customerLName[i];break;
                }
            }
        }//customers
        
        tableProductDiscounts=new DiscountProduct[r][c];
        //simulation of linked table to products
        tableProductDiscounts[0][0]=new DiscountProduct_Clearance();//first product, first discount
        tableProductDiscounts[1][0]=new DiscountProduct_Clearance();//second product, first discount
        tableProductDiscounts[2][0]=new DiscountProduct_Clearance();//third product, first discount
    }

    @Override
    public void connectToDatabase(String connectionPath, String databaseIdentification) {
        if(connectionPath==null || databaseIdentification==null){
            throw new UnsupportedOperationException(MSG_ERR_CONNECTION_FAILURE);
        } else{
            System.out.println(MSG_CONNECTION_SUCCESS);
        }
    }

    @Override
    public String[] readData(String table, String recordID) {
        String[] tableData= new String[c];
        
        
        if(table==null || recordID==null){
            throw new UnsupportedOperationException(MSG_ERR_TABLE); //To change body of generated methods, choose Tools | Templates.
        }else{
            
            switch(table){
                case "tableProducts": 
                    for(int i=0; i< tableProducts.length; i++){
                        if(tableProducts[i][INDEX_PRODUCT].equals(recordID)){
                            //System.out.println(tableProducts[i][INDEX_PRODUCT].equals(recordID));testing product match
                            
                            tableData[INDEX_PRODUCT]= tableProducts[i][INDEX_PRODUCT];
                            tableData[INDEX_DESCRIPTON]= tableProducts[i][INDEX_DESCRIPTON];
                            tableData[INDEX_PRICE]= tableProducts[i][INDEX_PRICE];
                        }
                    }
                    break;
                case "tableCustomer": break;
                default : throw new UnsupportedOperationException(MSG_ERR_TABLE); //To change body of generated methods, choose Tools | Templates.
            }
        }
        return tableData;
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
    
    @Override
    public DiscountProduct[] lookUpProductDiscount(String productID){
        DiscountProduct[] productDiscounts = new DiscountProduct[1];//at least 1 discount - default NoDiscount()
        boolean discountFound=false;
        int newSize=0;
        if(productID==null){
            throw new UnsupportedOperationException(MSG_ERR_TABLE); //To change body of generated methods, choose Tools | Templates.
        }else{
            
            for(int i=0;i< tableProducts.length; i++){
                        if(tableProducts[i][INDEX_PRODUCT].equals(productID)){
                            
                            //fetch discounts
                            for(int d=0;d<tableProductDiscounts[i].length;d++){
                                //array expansion :: avoid null values
                                if(tableProductDiscounts[i][d]!=null){
                                    discountFound=true;
                                    newSize++;
                                    
                                }
                            
                            
                            }
                            //enter discounts
                            productDiscounts=new DiscountProduct[newSize];
                            
                            for(int d=0;d<tableProductDiscounts[i].length;d++){
                                if(tableProductDiscounts[i][d]!=null){
                                productDiscounts[i]=tableProductDiscounts[i][d];
                                }
                            }
                        }
            }if(!discountFound){
                productDiscounts[0]=new DiscountProduct_NoDiscount();
            }
        }
        
        return productDiscounts;
    }
}
