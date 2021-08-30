package br.com.list.books.controllers;

import br.com.list.books.entity.Autor;
import br.com.list.books.entity.Livro;
import br.com.list.books.service.AutorService;
import br.com.list.books.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LivroController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd(){

        ModelAndView mv = new ModelAndView("bookform");
        List<Autor> autorList = this.autorService.getAutorList();
        mv.addObject("autorList", autorList);
        return mv;

    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Livro livro, BindingResult result,
                           RedirectAttributes redirect){
        if (result.hasErrors()) {
            redirect.addFlashAttribute("mensagem",
                    "Verifique os campos obrigatórios");
            return "redirect:/book/form/add";
        }

        this.livroService.save(livro);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id){

        ModelAndView mv = new ModelAndView("bookform");
        List<Autor> autorList = this.autorService.getAutorList();
        mv.addObject("autorList", autorList);

        Livro livro = this.livroService.findById(id);
        mv.addObject("livro", livro);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        this.livroService.delete(id);
        return "redirect:/";
    }

}
