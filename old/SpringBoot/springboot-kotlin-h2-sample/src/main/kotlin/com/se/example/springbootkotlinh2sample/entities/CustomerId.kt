package com.se.example.springbootkotlinh2sample.entities

import java.io.Serializable

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CustomerId(
        @Column(name = "customer_id")
        var customerId: Int = -1,

        @Column(name = "brandcode")
        var brandcode: String = ""
) : Serializable