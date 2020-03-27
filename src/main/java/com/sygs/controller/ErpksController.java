package com.sygs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/erp")
public class ErpksController {

    @GetMapping("/getDetails")
    public String   getDetails(){
        return "wewewe";
    }
    @GetMapping("/getInfo")
    public String    getInfo(HttpServletRequest  request,String billno, String entid, String type){
        System.err.println("*******"+billno+"******"+entid+"**********"+type);
        String jsonpcallback = request.getParameter("jsonpcallback") ;

        return  jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }
}
