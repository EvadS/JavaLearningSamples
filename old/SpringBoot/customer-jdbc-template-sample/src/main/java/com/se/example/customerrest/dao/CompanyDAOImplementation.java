package com.se.example.customerrest.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.se.example.customerrest.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDAOImplementation implements CompanyDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CompanyDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Company company) {
        if ((company.getCompanyId() != null ) && (company.getCompanyId() != "" ))
        {
            // Update
            String sql = "UPDATE company SET name=?, ceo=?, country=?,foundationYear=?,noOfEmployee=? WHERE companyId=?";
            jdbcTemplate.update(sql, company.getName(), company.getCeo(),company.getCountry(), company.getFoundationYear(), company.getNoOfEmployee(),company.getCompanyId());
        }
        else {
            // Insert
            String sql = "insert into company(name, ceo, country, foundationYear,noOfEmployee) VALUES (?, ?, ?, ?,?)";
            System.out.print(company.getName());
            jdbcTemplate.update(sql, company.getName(), company.getCeo(),company.getCountry(), company.getFoundationYear(), company.getNoOfEmployee());
        }

    }

    @Override
    public void delete(String companyId) {
        String sql = "DELETE FROM company WHERE companyId=?";
        jdbcTemplate.update(sql, companyId);
    }

    @Override
    public List<Company> list() {
       /* String sql = "SELECT * FROM company";
        List<Company> listCompany = jdbcTemplate.query(sql, new RowMapper<Company>() {

            @Override
            public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
                Company company = new Company();

                company.setCompanyId(rs.getString("companyId"));
                company.setName(rs.getString("name"));
                company.setCeo(rs.getString("ceo"));
                company.setCountry(rs.getString("country"));
                company.setFoundationYear(rs.getString("foundationYear"));
                company.setNoOfEmployee(rs.getString("noOfEmployee"));

                return company;
            }

        });

        return listCompany;
*/
        return jdbcTemplate.query("select * from company", ROW_MAPPER);
    }

    @Override
    public Company get(String companyId) {
        String sql = "SELECT * FROM company WHERE companyId=" + companyId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Company>() {

            @Override
            public Company extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Company company = new Company();

                    company.setCompanyId(rs.getString("companyId"));
                    company.setName(rs.getString("name"));
                    company.setCeo(rs.getString("ceo"));
                    company.setCountry(rs.getString("country"));
                    company.setFoundationYear(rs.getString("foundationYear"));
                    company.setNoOfEmployee(rs.getString("noOfEmployee"));

                    return company;
                }
                return null;
            }

        });
    }
}