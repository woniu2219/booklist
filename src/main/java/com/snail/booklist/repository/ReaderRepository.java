package com.snail.booklist.repository;

import com.snail.booklist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Snail
 * @date 2019/11/19 22:20
 */
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findByUserName(String userName);
}
