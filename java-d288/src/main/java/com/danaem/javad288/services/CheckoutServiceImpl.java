package com.danaem.javad288.services;

import com.danaem.javad288.dao.CartRepository;
import com.danaem.javad288.entities.Cart;
import com.danaem.javad288.entities.CartItem;
import com.danaem.javad288.entities.Customer;
import com.danaem.javad288.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository ;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {

        this.cartRepository = cartRepository ;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart() ;

        String orderTrackingNumber = generateOrderTrackingNumber() ;
        cart.setOrderTrackingNumber(orderTrackingNumber) ;
        cart.setStatus(StatusType.CartStatus.ordered) ;

        Set<CartItem> cartItems = purchase.getCartItems() ;
        cartItems.forEach(item -> cart.add(item)) ;

        Customer customer = purchase.getCustomer() ;
        customer.add(cart) ;
        cartRepository.save(cart) ;

        return new PurchaseResponse(orderTrackingNumber) ;
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString() ;

    }
}
