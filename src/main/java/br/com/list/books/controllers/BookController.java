package br.com.list.books.controllers;

import br.com.list.books.entity.Autor;
import br.com.list.books.entity.Livro;
import br.com.list.books.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/book/add")
    public ModelAndView getFormAdd(){

        ModelAndView mv = new ModelAndView("bookform");
        List<Autor> autorList = this.autorService.getAutorList();
        mv.addObject("autorlist", autorList);

        return mv;

    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Livro livro, BindingResult result,
                           RedirectAttributes redirect){
        if (result.hasErrors()){
            redirect.addFlashAttribute("mensagem",
                    "verifique os campos obrigatórios!");
            return "redirect:/book/form/add";
        }
        return "redirect:/lista";
    }
}
