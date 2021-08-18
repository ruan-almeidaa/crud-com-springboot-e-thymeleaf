package br.com.list.books.repository;

import br.com.list.books.entity.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}
