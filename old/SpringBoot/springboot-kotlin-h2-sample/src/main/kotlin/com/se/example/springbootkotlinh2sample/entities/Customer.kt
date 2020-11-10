package com.se.example.springbootkotlinh2sample.entities

import javax.annotation.Generated
import javax.persistence.*

@Entity
class Customer(

        @EmbeddedId
        var customerId: CustomerId? = null,

        @Column(name = "company")
        var company: String = "",
        var name: String
)