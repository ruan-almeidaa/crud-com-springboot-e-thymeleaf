package br.com.list.books.repository;

import br.com.list.books.entity.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
