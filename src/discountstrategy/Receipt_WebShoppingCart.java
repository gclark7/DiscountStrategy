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
    private LineItem expandLineItems;//used inside addLineItem() to expand array of LineItems
    private LineItem[] lineItems;
    private DatabaseConnection db;
    private Customer customer;
    
    
    public Receipt_WebShoppingCart(){
        
        lineItems=new LineItem[0];
        
                
    }
    
    @Override
    public void removeLineItem(int i) {
       LineItem[] temp=new LineItem[lineItems.length-1];
       int STARTING_INDEX=0;
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
        }
       
    }

    @Override
    public void printReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
