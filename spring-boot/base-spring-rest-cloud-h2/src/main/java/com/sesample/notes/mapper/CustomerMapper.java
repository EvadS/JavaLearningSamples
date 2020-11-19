package com.sesample.notes.mapper;

import com.sesample.notes.entities.Customer;
import com.sesample.notes.entities.Note;
import com.sesample.notes.model.CustomerRequest;
import com.sesample.notes.model.CustomerResponse;
import com.sesample.notes.model.NoteRequest;
import com.sesample.notes.model.NoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    Customer customerRequestToCustomer(CustomerRequest noteRequest);

    CustomerResponse customerToCustomerResponse(Customer note);
}
