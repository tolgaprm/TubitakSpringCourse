package yte.intern.springdata.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springdata.entity.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    List<Book> findByAgeGreaterThan(Long age, Sort sort);

    List<Book> findByPublishDateAfter(LocalDate publishDate, PageRequest pageRequest);

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);

    Long countByAuthor(String author);

    boolean existsByAuthor(String author);
}