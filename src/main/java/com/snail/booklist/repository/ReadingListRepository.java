package com.snail.booklist.repository;


import com.snail.booklist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Snail
 * @date 2019/11/17 10:43
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReader(String reader);
}
