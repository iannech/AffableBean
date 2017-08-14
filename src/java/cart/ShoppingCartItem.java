/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Product;

/**
 *
 * @author nech
 */
public class ShoppingCartItem {
    
    private Product product;
    private short quantity;
    
    public ShoppingCartItem(Product product){
        this.product = product;
        quantity = 1;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public short getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
    
    public void incrementQuantity(){
        quantity ++;
    }
    
}
