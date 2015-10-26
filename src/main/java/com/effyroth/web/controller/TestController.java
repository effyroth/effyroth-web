package com.effyroth.web.controller;

import com.effyroth.core.services.TestService;
import com.effyroth.core.structs.TestObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guzhen on 15/10/22.
 */
@Controller
//@EnableAutoConfiguration
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ModelAndView Test(){
//        if (log.isDebugEnabled()){
            log.debug("test");
//        }
        String pong = null;
        try {
            pong = testService.testPing();
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.toString());
        }
        log.debug(pong);
        TestObject testObject = null;
        try {
            testObject = testService.testMethod(1L,"thrift test", true);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.toString());
            e.printStackTrace();
        }
        log.debug(testObject.getTestString());
        log.debug(String.valueOf(testObject.getTestLong()));
        log.debug(String.valueOf(testObject.isTestBool()));
        ModelAndView model = new ModelAndView();
//        model.setViewName(testObject.getTestString());
        log.debug("before return model");
        return model;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(TestController.class, args);
//    }
}
