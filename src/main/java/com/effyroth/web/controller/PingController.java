package com.effyroth.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.URL;

/**
 * Created by guzhen on 15/10/22.
 */
@Controller
public class PingController {

    private final Logger log = LoggerFactory.getLogger(PingController.class);

    @RequestMapping(value="/ping", method = RequestMethod.GET)
    public ModelAndView Ping(){
        log.info("ping");
        log.debug("ping");
        ModelAndView model = new ModelAndView();
        model.setViewName("pong");
        return model;
    }
}
