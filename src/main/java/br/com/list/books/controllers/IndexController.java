package br.com.list.books.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @GetMapping("/lista")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
