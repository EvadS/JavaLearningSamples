package com.se.example.customerrest.dao;
import com.se.example.customerrest.entities.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;


public interface CompanyDAO {

    RowMapper<Company> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Company(
                resultSet.getString("companyId")
                , resultSet.getString("name")
                , resultSet.getString("ceo")
                , resultSet.getString("country")
                , resultSet.getString("foundationYear")
                , resultSet.getString("noOfEmployee")

        );
    };

    public void saveOrUpdate(Company company);

    public void delete(String companyId);

    public Company get(String companyId);

    public List<Company> list();
}