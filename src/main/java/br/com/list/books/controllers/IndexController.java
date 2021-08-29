package br.com.list.books.controllers;

import br.com.list.books.entity.Livro;
import br.com.list.books.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/")
    public ModelAndView getList(){

        List<Livro> livroList=this.livroService.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("livroList", livroList);
        return mv;
    }
}
