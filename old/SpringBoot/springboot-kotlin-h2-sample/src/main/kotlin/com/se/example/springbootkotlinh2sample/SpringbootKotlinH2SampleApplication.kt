package com.se.example.springbootkotlinh2sample

import com.se.example.springbootkotlinh2sample.entities.Customer
import com.se.example.springbootkotlinh2sample.entities.CustomerId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.se.example.springbootkotlinh2sample.service.*

@SpringBootApplication
class SpringbootKotlinH2SampleApplication : CommandLineRunner {

    @Autowired
    lateinit var customerService: CustomerServices

    override fun run(vararg args: String?) {
        save();
        save();

        showAll();
    }


    private fun save() {
        println("---> Store Customers")
        // ===============Create customers===============
        // 1. Jack
        val jackId = CustomerId(1000, "azc")
        val jack = Customer(jackId, "A & Z", "Jack")

        // 2. Mary
        val maryId = CustomerId(2000, "mkl")
        val mary = Customer(maryId, "Fashion Company", "Mary")

        // ===============Saving to DB===============
        customerService.save(jack)
        customerService.save(mary)
    }


    fun showAll() {
        println("===============Show All Customers' Info===============")
        customerService.showAll()
    }


}

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinH2SampleApplication>(*args)
}

