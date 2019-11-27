package com.sumutella.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumutella
 * @time 3:26 PM
 * @since 11/27/2019, Wed
 */
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html" })
    public String listVets(){
        return "vets/index";
    }
}