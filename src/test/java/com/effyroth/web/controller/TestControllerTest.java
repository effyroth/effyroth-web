package com.effyroth.web.controller;

import com.effyroth.core.services.TestService;
import com.effyroth.core.structs.TestObject;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* TestController Tester. 
* 
* @author <Authors name> 
* @since <pre>十月 26, 2015</pre> 
* @version 1.0 
*/ 
public class TestControllerTest {

//    Logger log = LoggerFactory.getLogger(TestControllerTest.class);
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: Test()
    *
    */
    @Test
    public void testTest() throws Exception {
    //TODO: Test goes here...
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "spring-core-config.xml",
                "dubbo-consumer.xml"
        );
        context.start();
        TestService testService = (TestService)context.getBean("testService");
        TestObject testObject = testService.testMethod(1L, "test", false);
        System.out.println(testObject.getTestString());
        System.out.println(testObject.isTestBool());
        System.out.println(testObject.getTestLong());
//        log.debug(testObject.toString());
    }

    /**
    *
    * Method: home()
    *
    */
    @Test
    public void testHome() throws Exception {
    //TODO: Test goes here...
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "spring-core-config.xml",
                "dubbo-consumer.xml"
        );
        context.start();
        TestService testService = (TestService)context.getBean("testService");
        testService.testPing();
    }


} 
