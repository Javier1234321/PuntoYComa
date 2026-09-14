package com.springboot.app.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.app.book.dao.BookDao;
@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(BookDao bookDao) {

    return args -> {
    	   log.info("Cargando libros...");
    	   
           log.info("Libros cargados");
    };
  }
}
