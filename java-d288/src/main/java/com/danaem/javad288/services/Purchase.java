package com.danaem.javad288.services;

import com.danaem.javad288.entities.Customer ;
import com.danaem.javad288.entities.Cart ;
import com.danaem.javad288.entities.CartItem ;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer ;

    private Cart cart ;

    private Set<CartItem> cartItems ;

}
