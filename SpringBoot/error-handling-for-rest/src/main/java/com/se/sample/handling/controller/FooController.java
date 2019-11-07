package com.se.sample.handling.controller;

import com.se.sample.handling.exception.CustomException1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")


@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")

public class FooController {
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/ex1")
    public void handleException() throws CustomException1 {
        //
        throw  new CustomException1();
    }

    @GetMapping("/ex1-throws")
    //@ExceptionHandler(value = {CustomException1.class, CustomException2.class})
    public void handleExceptionthrow() throws CustomException1  {
        throw  new CustomException1();
    }


    @GetMapping("/ex1-1")
    public String test() {
        //
        return "test";
    }

    @ApiOperation(value = "Correct display exception")
    @GetMapping("/ex1-not-found-exception")
    public String test2() throws ResourceNotFoundException {
        throw  new ResourceNotFoundException("ResourceNotFoundException");
    }
}
