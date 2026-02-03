package com.elixirr.labRedo2.Services;

import com.elixirr.labRedo2.DAO.CartRepository;
import com.elixirr.labRedo2.DAO.CustomerRepository;
import com.elixirr.labRedo2.Entities.Cart;
import com.elixirr.labRedo2.Entities.CartItem;
import com.elixirr.labRedo2.Entities.Customer;
import com.elixirr.labRedo2.Entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //get the cart info from the dto
        Cart cart = purchase.getCart();

        //get customer info from the dto
        Customer customer = purchase.getCustomer();

        //Generate the Tracking Number
        String orderTrackingNumber = generateOrderTrackingNumber();

        //populate the cart with the cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        //change the cart status to ordered
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        customer.add(cart);

        //save the cart to the appropriate repository
        cartRepository.save(cart);
        customerRepository.save(customer);

        //return the tracking number
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
