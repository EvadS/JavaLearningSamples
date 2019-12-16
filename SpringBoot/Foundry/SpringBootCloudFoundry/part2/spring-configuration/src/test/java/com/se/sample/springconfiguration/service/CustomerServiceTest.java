package com.se.sample.springconfiguration;



import com.se.sample.TestConfiguration;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class,
        TestConfiguration.class })
public class CustomerServiceTest{

//    @Rule
//    public OutputCapture outputCapture = new OutputCapture();
//
    @Autowired
    private CustomerService customerService;

//    @Test
//    public void findAll() throws Exception {
//        int size = this.customerService.findAll().size();
//        Assert.assertEquals(size, 2);
//        String consoleOutput = this.outputCapture.toString();
//        Assert.assertThat(consoleOutput, containsString("starting @"));
//        Assert.assertThat(consoleOutput, containsString("finishing @"));
//    }

    @Test
    public void tt(){

    }
}