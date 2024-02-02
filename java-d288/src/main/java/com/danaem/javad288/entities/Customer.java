package com.danaem.javad288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id ;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName ;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName ;

    @Column(name = "address", nullable = false)
    private String address ;

    @Column(name = "postal_code", nullable = false)
    private String postal_code ;

    @Column(name = "phone", nullable = false)
    private String phone ;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date ;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update ;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division ;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>() ;


    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>() ;
            }
            carts.add(cart) ;
            cart.setCustomer(this) ;
        }
    }

    public Customer() {
      this.firstName = "unknown" ;
      this.lastName = "unknown" ;
      this.address = "unknown" ;
      this.postal_code = "unknown" ;
      this.phone = "unknown" ;
      Division division = new Division() ;
      division.setId(8L);
      this.division = division;
    }

    public Customer(String firstName, String lastName, String address, String phone, String postal_code, Long division_id) {
      this.firstName = firstName ;
      this.lastName = lastName ;
      this.address = address ;
      this.postal_code = postal_code ;
      this.phone = phone ;
      this.division = setDivision(division_id);
    }

    public Division setDivision(Long id) {
      Division division = new Division() ;
      division.setId(id) ;
      return division ;
    }

}
