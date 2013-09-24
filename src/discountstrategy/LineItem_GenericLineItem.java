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
    
    int[] productQtys;
    Product[] products;

    public LineItem_GenericLineItem(){
        productQtys=new int[0];
        products = new Product[0];
    }
    
    @Override 
    public Product[] getLineItem(){
        return products;
    }
    
    @Override
    public String[] getProductRecord() {
        //this is too printout product details
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLineItem(Product product, int qty) {//delegate to Product to return a Product
         if(product==null || qty<=0){
            throw new UnsupportedOperationException("MSG_ERR_NULL");
        } else{
            //run the array expander
             //product
        
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
        
        }
        
        
    }

    @Override
    public void setItemQuantity(int qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getItemQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public void removeLineItem(int i){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
