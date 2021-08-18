package br.com.list.books.service;

import br.com.list.books.entity.Autor;
import br.com.list.books.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAutorList(){
        Iterable<Autor> autorIterable = this.autorRepository.findAll();
        return Streamable.of(autorIterable).toList();
    }
}
