package yte.intern.springdata.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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


    @Query("SELECT b FROM Book b WHERE b.title = :title ")
    Book findByTitleWithQuery(String title);

    @Query("SELECT b FROM Book b WHERE b.age >= :age")
    List<Book> findByAgeGreaterThanWithQuery(Long age, Sort sort);

    @Query("SELECT b FROM Book b WHERE b.publishDate >= :publishDate")
    List<Book> findByPublishDateAfterWithQuery(LocalDate publishDate, PageRequest pageRequest);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findByTitleLikeWithQuery(String title);

    @Query("SELECT b FROM Book b WHERE b.author = :author AND b.age >= :age")
    List<Book> findByAuthorAndAgeGreaterThanWithQuery(String author, Long age);

    @Query("SELECT COUNT(b) FROM Book b WHERE b.author = :author")
    Long countByAuthorWithQuery(String author);
}