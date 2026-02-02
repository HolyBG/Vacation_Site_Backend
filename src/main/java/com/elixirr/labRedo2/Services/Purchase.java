package com.elixirr.labRedo2.Services;

import com.elixirr.labRedo2.Entities.Cart;
import com.elixirr.labRedo2.Entities.CartItem;
import com.elixirr.labRedo2.Entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
