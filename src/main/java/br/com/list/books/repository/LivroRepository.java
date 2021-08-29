package br.com.list.books.repository;

import br.com.list.books.entity.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    @Override
    List<Livro> findAll();
}
