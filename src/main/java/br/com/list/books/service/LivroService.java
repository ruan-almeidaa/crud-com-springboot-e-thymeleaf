package br.com.list.books.service;

import br.com.list.books.entity.Livro;
import br.com.list.books.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public void save(Livro livro){

        this.livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return this.livroRepository.findAll();
    }
}
