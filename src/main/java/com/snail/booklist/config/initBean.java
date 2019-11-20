package com.snail.booklist.config;

import com.snail.booklist.entity.Reader;
import com.snail.booklist.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liwenbo
 * @Date 2019/11/20 17:37
 * @Description
 */
@Component
public class initBean {

    @Autowired
    private ReaderRepository readerRepository;

    @PostConstruct
    public void init() {
        ceateReater();
    }

    public void ceateReater() {
        Reader reader = new Reader();
        reader.setUserName("admin");
        reader.setFullName("liwenbo");
        reader.setPassword("123");
        readerRepository.save(reader);
    }
}
