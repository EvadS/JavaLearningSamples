package com.se.example.customerrest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.se.example.customerrest.dao.CompanyDAO;
import com.se.example.customerrest.entities.Company;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @author Shardul.Bartwal
 *
 */

/**
 * ServiceController will be serving for all rest-full web client request.
 */
@RequestMapping("/v2/company/")
@RestController
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private View jsonView;

    private final String DATA_FIELD = "data";
    private final String ERROR_FIELD = "error";

    private static final Logger logger_c = Logger.getLogger(CompanyController.class);

    /**
     * Gets all companies.
     * @return the list of companies.
     */
    @RequestMapping(value = "/getcompanyall/", method = RequestMethod.GET)
    public List<Company> getcompanyall() throws IOException
    {
        System.out.println("Inside getCompanyAll()");
        List<Company> companyList = null;

        try {
            companyList = companyDAO.list();
        } catch (Exception exception) {
            String errMsg = "Error getting all companies.";
        //    return errorResponder(String.format(errMsg, exception.toString()));
        }
        logger_c.debug("Returing CompanyList: " + companyList.toString());

            ModelAndView modelAndView = new ModelAndView();

  
        return companyList;

       // return new ModelAndView(jsonView, DATA_FIELD, companyList);
    }

    /**
     * Get company by id.
     * @param companyId
     * @return the Company
     */
    @RequestMapping(value = "/getcompany/{companyId}", method = RequestMethod.GET)
    public ModelAndView getcompany(@PathVariable String companyId)
    {
        System.out.println("Inside getcompany()");
        Company company = null;
        try {
            company = companyDAO.get(companyId);
        } catch (Exception exception) {
            String errMsg = "Error getting company.";
            return errorResponder(String.format(errMsg, exception.toString()));
        }
        logger_c.debug("Returing CompanyList For Single Company: " + company.toString());
        return new ModelAndView(jsonView, DATA_FIELD, company);
    }

    /**
     * Delete Company by companyId.
     * @param companyId
     * @return the Company
     */
    @RequestMapping(value = "/deletecompany/{companyId}", method = RequestMethod.GET)
    public ModelAndView deletecompany(@PathVariable String companyId)
    {
        System.out.println("Inside deletecompany()");
        String deleteMsg = "";
        try {
            companyDAO.delete(companyId);
            deleteMsg = "Deleted Successfully";
        } catch (Exception exception) {
            String errMsg = "Error getting company.";
            return errorResponder(String.format(errMsg, exception.toString()));
        }
        logger_c.debug("Returing CompanyList For Single Company: " + deleteMsg.toString());

        return new ModelAndView(jsonView, DATA_FIELD, deleteMsg);
    }

    /**
     * Creates a new Company.
     * @param companyStr
     * @return the model and view
     */
    @RequestMapping(value = { "/createcompany/" }, method = { RequestMethod.POST },headers = {"Accept=application/json"} )
    public ModelAndView createcompany(@RequestBody  String companyStr,HttpServletResponse httpResponse,WebRequest webRequest){
        System.out.println("Inside createcompany()"+ companyStr);
        Company company = null;
        String successMsg;
        try {
            company = new ObjectMapper().readValue(companyStr, Company.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger_c.debug("Creating Company: " + companyStr.toString());

        try {
            companyDAO.saveOrUpdate(company);
            successMsg = "Company Saved Successfully.";
        } catch (Exception e) {
            String errMsg = "Error creating new Company.";
            return errorResponder(String.format(errMsg, e.toString()));
        }

        httpResponse.setStatus(HttpStatus.CREATED.value());
        httpResponse.setHeader("Location", webRequest.getContextPath() + "/createcompany/" + company.name);
        return new ModelAndView(jsonView, DATA_FIELD, successMsg);
    }

    /**
     * Update a Company.
     * @param companyStr
     * @return the model and view
     */
    @RequestMapping(value = { "/updatecompany/" }, method = { RequestMethod.POST }, headers = {"Accept=application/json"} )
    public ModelAndView updatecompany(@RequestBody String companyStr,HttpServletResponse httpResponse,WebRequest webRequest)
    {
        System.out.println("Inside updateCompany()" + companyStr);
        Company company = null;
        String updateMsg = "";
        try {
            company = new ObjectMapper().readValue(companyStr, Company.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger_c.debug("Updating Company: " + companyStr.toString());

        try {
            companyDAO.saveOrUpdate(company);
            updateMsg = "Updated Successfully.";
        } catch (Exception e) {
            String errMsg = "Error in updating Company.";
            return errorResponder(String.format(errMsg, e.toString()));
        }

        httpResponse.setStatus(HttpStatus.OK.value());
        httpResponse.setHeader("Location", webRequest.getContextPath() + "/updatecompany/" + company.name);
        return new ModelAndView(jsonView, DATA_FIELD, updateMsg);
    }

    /**
     * Create an error REST response.
     * @param errMsg,error message
     * @return model and view
     */
    private ModelAndView errorResponder(String errMsg) {
        return new ModelAndView(jsonView, ERROR_FIELD, errMsg);
    }

}