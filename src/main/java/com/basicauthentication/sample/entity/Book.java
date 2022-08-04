package com.basicauthentication.sample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TT_BOOK")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name field should not be null!")
    private String name;
    @NotNull(message = "Price field should not be null!")
    private String price;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

}
