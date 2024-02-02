package com.danaem.javad288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id ;

    @Column(name = "division")
    private String division_name ;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date ;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, updatable = false, insertable = false)
    private Country country ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customers ;

    @Column(name = "country_id")
    private long country_id ;

    public void setCountry(Country country) {
      setCountry_id(country.getId()) ;
      this.country = country;
    }

}
