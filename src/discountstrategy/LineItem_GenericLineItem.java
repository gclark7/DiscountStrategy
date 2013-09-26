/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author gcDataTechnology
 */
public class LineItem_GenericLineItem implements LineItem{
    private final String MSG_ERR_NULL="Null value";
    private int productQty;
    private Product product;

    public LineItem_GenericLineItem(Product product, int qty){
        //error handling in setLineItem method
        setLineItem(product, qty);
    }
    
    @Override 
    public Product getLineItem(){
        return product;
    }
    
    @Override
    public String[] getProductRecord() {
       return product.getProductRecord();
    }

    @Override
    public void setLineItem(Product product, int qty) {//delegate to Product to return a Product
         if(product==null || qty<=0){
            throw new UnsupportedOperationException(MSG_ERR_NULL);
        } else{
             
             this.product=product;
             productQty=qty;
            //run the array expander
             //product
        /*//Originally had this as an array, Receipt now has LineItem[]
        int indexStart=0;
        int newSize=this.products.length + 1;
        Product[] temp = new Product[newSize];
        int elementIndex = temp.length-1;
        System.arraycopy(this.products, indexStart, temp, indexStart, elementIndex);
        temp[elementIndex]= product;
        this.products=temp;
        
        //qty
        newSize=this.productQtys.length + 1;
        int[] tempQ = new int[newSize];
        elementIndex = temp.length-1;
        System.arraycopy(this.productQtys, indexStart, tempQ, indexStart, elementIndex);
        tempQ[elementIndex]=qty;
        this.productQtys=tempQ;
        */
             
        }
        
        
    }

    @Override
    public void setItemQuantity(int qty) {
        if(qty<=0){
            throw new UnsupportedOperationException(MSG_ERR_NULL); //To change body of generated methods, choose Tools | Templates.
        }else{productQty=qty;}
        
    }

    @Override
    public int getItemQuantity() {
        return productQty;
    }

   /*//moved to receipt LineItem[ ]
    @Override
    public void removeLineItem(int i){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    */
    
   
    
}
