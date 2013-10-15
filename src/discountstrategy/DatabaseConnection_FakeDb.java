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
 * Array indexes are used as primaryKeys & foreignKeys
 * 
 * The tables are 2 dimensional arrays based upon several data arrays -- they populate inside the constructor
 * 
 * IN THE FUTURE a connection to a real relational database is anticipated to retrieved data through Views in the database
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
    private int c1=7;
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
    private String[] customerAddress={"123 Burleigh Street","327 Blackville Street","5289 Coutyard Court"};
    private String[] customerCity={"Waukesha","Milwaukee","Greenbay"};
    private String[] customerState={"WI","WI","WI"};
    private String[] customerZip={"53205","53214","53650"};
    
    private String[][] tableCustomers;
    private final int INDEX_ID=0;
    private final int INDEX_FNAME=1;
    private final int INDEX_LNAME=2;
    private final int INDEX_ADDRESS=3;
    private final int INDEX_CITY=4;
    private final int INDEX_STATE=5;
    private final int INDEX_ZIP=6;
    
    /**
     * Discounts and discount rates are simulated in the database where they would be
     * updated by accounting personnel / sales strategist
     * Products are independent of their discounts, however they are linked to them through data relationships
     * 
     * Requirements for this project are the products have 1 discount - I have met that requirement and 
     * allowed for expansion in the future
     * 
     * Also I've added sale discounts that can be added to in the future - these are anticipated to reduce 
     * the entire cost of the sale, not the product cost
     */
    private DiscountProduct[][] tableProductDiscounts;
    private final double DISCOUNT_RATE=0.75;
    
    private DiscountSale[] saleDiscounts={new DiscountSale_KohlsCash()};
    
    /**
     * 
     * Class constructor
     * simulates a connection to a database less admin permissions
     * The necessary tables are simulated through multi-dimensional arrays which are populated here
     * 
     * 
     */
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
        
        tableCustomers=new String[r][c1];
        for(int i=0;i<r;i++){
            //outer record by record
            for(int j=0;j<c1;j++){
                //populate columns
                switch(j){
                    case INDEX_ID:tableCustomers[i][j]=customerID[i];break;
                    case INDEX_FNAME:tableCustomers[i][j]=customerFName[i];break;
                    case INDEX_LNAME:tableCustomers[i][j]=customerLName[i];break;
                    case INDEX_ADDRESS:tableCustomers[i][j]=customerAddress[i];break;
                    case INDEX_CITY:tableCustomers[i][j]=customerCity[i];break;
                    case INDEX_STATE:tableCustomers[i][j]=customerState[i];break;
                    case INDEX_ZIP:tableCustomers[i][j]=customerZip[i];break;
                    
                }
            }
        }//customers
        
        tableProductDiscounts=new DiscountProduct[r][c];//default array size
        //simulation of relational link to tableProducts
        tableProductDiscounts[0][0]=new DiscountProduct_Clearance(DISCOUNT_RATE);//first product, first discount
        tableProductDiscounts[1][0]=new DiscountProduct_Clearance(DISCOUNT_RATE);//second product, first discount
        tableProductDiscounts[2][0]=new DiscountProduct_Clearance(DISCOUNT_RATE);//third product, first discount
    }
    
    /**
     * Called from the constructor to establish connection
     * @param connectionPath
     * @param databaseIdentification 
     */
    @Override
    public void connectToDatabase(String connectionPath, String databaseIdentification) {
        if(connectionPath==null || databaseIdentification==null){
            throw new UnsupportedOperationException(MSG_ERR_CONNECTION_FAILURE);
        } else{
            System.out.println(MSG_CONNECTION_SUCCESS);
        }
    }
    
    /**
     * 
     * Simulates reading data from tables in a database
     * This simulation takes the table and the primary key to return entire record
     * 
     * @param table
     * @param recordID
     * @return 
     */
    @Override
    public String[] readData(String table, String recordID) {
        String[] tableData;
        
        
        if(table==null || recordID==null){
            throw new UnsupportedOperationException(MSG_ERR_TABLE); //To change body of generated methods, choose Tools | Templates.
        }else{
            
            switch(table){
                case "tableProducts": 
                    tableData= new String[c];
                    for(int i=0; i< tableProducts.length; i++){
                        if(tableProducts[i][INDEX_PRODUCT].equals(recordID)){
                            
                            
                            tableData[INDEX_PRODUCT]= tableProducts[i][INDEX_PRODUCT];
                            tableData[INDEX_DESCRIPTON]= tableProducts[i][INDEX_DESCRIPTON];
                            tableData[INDEX_PRICE]= tableProducts[i][INDEX_PRICE];
                        }
                    }
                    break;
                case "tableCustomers":
                    tableData= new String[c1];
                    for(int i=0; i< tableCustomers.length; i++){
                        if(tableCustomers[i][INDEX_ID].equals(recordID)){
                            
                            tableData[INDEX_ID]= tableCustomers[i][INDEX_ID];
                            tableData[INDEX_FNAME]= tableCustomers[i][INDEX_FNAME];
                            tableData[INDEX_LNAME]= tableCustomers[i][INDEX_LNAME];
                            tableData[INDEX_ADDRESS]= tableCustomers[i][INDEX_ADDRESS];
                            tableData[INDEX_CITY]= tableCustomers[i][INDEX_CITY];
                            tableData[INDEX_STATE]= tableCustomers[i][INDEX_STATE];
                            tableData[INDEX_ZIP]= tableCustomers[i][INDEX_ZIP];
                            
                        }
                    }
                    break;
                default : throw new UnsupportedOperationException(MSG_ERR_TABLE); //To change body of generated methods, choose Tools | Templates.
            }
        }
        return tableData;
    }
    
    /**
     * 
     * not created yet
     * to be used by real database connection
     * @param data
     * @param table 
     */
    @Override
    public void writeData(String[] data, String table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * 
     * not created yet
     * to be used by real database connection
     * @param data
     * @param table 
     */
    @Override
    public void disconnectConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * 
     * not created yet
     * to be used by real database connection
     * @param data
     * @param table 
     */
    @Override
    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * 
     * simulates the lookUP tables for a product discount
     * where a product record would be linked to a discount table
     * this simulates a stored procedure in the database
     * 
     * @param data
     * @param table 
     */
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
                            
                            //fetch discounts:: i is the product table index "primary Key"
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
                                productDiscounts[d]=tableProductDiscounts[i][d];
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
