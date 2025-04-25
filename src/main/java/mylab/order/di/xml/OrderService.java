package mylab.order.di.xml;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    @Autowired
    private ShoppingCart shoppingCart;

    public OrderService() {}

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public double calculateOrderTotal() {
        return shoppingCart.getTotalPrice();
    }

    @Override
    public String toString() {
        return "OrderService [shoppingCart=" + shoppingCart + "]";
    }
}