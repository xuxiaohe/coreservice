/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transn.houtai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/ueditor")
public class UEditorController {



    @RequestMapping(value = "/test")
    public String test() {

        return "ueditor";
    }

}
