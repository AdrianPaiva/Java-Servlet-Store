/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class CompleteOrder {
    
    public void completeOrder(int userId)
    {
        ShoppingCart sc = new ShoppingCart();
        Catalog c = new Catalog();
        
        for (ShoppingCartProduct scp : sc.getProductsInCart(userId)) 
        {
            for (Product p : c.getCatalog()) {
                
                if(scp.getProductId() == p.getId())
                {
                    if(p.getQuantityInStock() - scp.getQuantity() == 0)
                    {
                        c.deleteProduct(p.getId());
                    }
                    else
                    {
                        int newQuantity = (p.getQuantityInStock() - scp.getQuantity());
                        c.updateStock(p.getId(), newQuantity);
                    }
                    
                    sc.removeItemFromCart(userId, scp.getProductId());
                }
            }
            
            
        }
    }
}
