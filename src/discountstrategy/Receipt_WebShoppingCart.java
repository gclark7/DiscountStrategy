/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class Receipt_WebShoppingCart implements Receipt{
    private final String MSG_ERR_NULL="Null value";
    private final String MSG_ERR_LISTED="Product already listed";
    private final String MSG_SAVINGS="Your savings is: ";
    private final String MSG_SUBTOTAL="total: ";
    private final String MSG_TAX="tax: ";
    private final String MSG_GRANDTOTAL="Grand Total: ";
    private LineItem expandLineItems;//used inside addLineItem() to expand array of LineItems
    private LineItem[] lineItems;
    private DatabaseConnection db;
    private Customer customer;;
    private final String TABLE_CUSTOMER="tableCustomers";
    private Tax taxRate;
    
    public Receipt_WebShoppingCart(DatabaseConnection db){
        
        lineItems=new LineItem[0];
        taxRate=new Tax_WI();
        customer=new Customer_AnonymousCustomer();
        this.db=db;
        
                
    }
    
    @Override
    public void removeLineItem(int i) {
       LineItem[] temp=new LineItem[lineItems.length-1];
       //int STARTING_INDEX=0;
       for(int x=0;x<lineItems.length;x++){
           if(lineItems[i]!=lineItems[x]){//skips recorded intended for removal
               temp[x]=lineItems[x];
           }
       }
      lineItems=temp;//points to temp array location less deleted record
        
    }

    @Override
    public void addLineItem(Product product, int qty) {
        
        if(product==null || qty<=0){
            throw new UnsupportedOperationException(MSG_ERR_NULL);
        } else{
            boolean listed=false;
            for(LineItem i:lineItems){
                if(i==product){
                    listed=true;
                }
            }
            if(!listed){
            //run the array expander
             //product
      
            int indexStart=0;
            int newSize=lineItems.length + 1;
            LineItem[] temp = new LineItem[newSize];
            int elementIndex = temp.length-1;
            System.arraycopy(lineItems, indexStart, temp, indexStart, elementIndex);
            expandLineItems=new LineItem_GenericLineItem(product, qty);
            temp[elementIndex]= expandLineItems;
            lineItems=temp;
            }else{throw new UnsupportedOperationException(MSG_ERR_LISTED);}
        
        }
       
    }

    @Override
    public void printReceipt() {
        double subTotal=0.00;
        double savings=0.00;
        double itemPrice=0.00;
        double tax=0.00;
        
        
         for(LineItem i:lineItems){
             //lineItem details --> delegates to Product to return record data
             System.out.println("");
             
             for(int j=0;j<i.getProductRecord().length;j++){
                  itemPrice=i.getLineItemCost();
                  subTotal+=itemPrice;
                  
                  System.out.print(i.getProductRecord()[j] + "\t");
             }
             //display LineItem qty
                  System.out.print("\t" + i.getItemQuantity());
             
             //lineItem discount --> delegates to Product --> delegates to Discount
                  for(int d=0; d< i.getLineItem().getProductDiscount().length;d++){
                        savings+=i.getLineItem().getProductDiscount()[d].reducePrice(i.getItemQuantity()*itemPrice);
                  }
         }
         System.out.println("\n\t" + MSG_SAVINGS + savings);
         System.out.println("\n\t\t" + MSG_SUBTOTAL + (subTotal-savings));
         
         tax=taxRate.taxTheSale((subTotal-savings));
         
         System.out.println("\t\t" + MSG_TAX + tax);
         System.out.println("\t" + MSG_GRANDTOTAL + ((subTotal-savings)+tax) + "\n\n");
             
    }

    
    @Override
    public void setCustomer(String customerID){
       customer=new Customer_RegisteredCustomer(customerID, db);
    }
    
}
