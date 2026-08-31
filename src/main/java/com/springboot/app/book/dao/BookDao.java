package com.springboot.app.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.book.models.entity.Book;


public interface BookDao extends JpaRepository<Book,Long>{
	@Query("""
			SELECT b FROM Book b
			LEFT JOIN b.author a
			LEFT JOIN b.publisher p
			LEFT JOIN a.nationality n
			WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :query,'%'))
			OR LOWER(a.firstName) LIKE LOWER(CONCAT('%', :query,'%'))
			OR LOWER(a.lasttName) LIKE LOWER(CONCAT('%', :query,'%'))
			OR LOWER(p.publisher) LIKE LOWER(CONCAT('%', :query,'%'))
			OR LOWER(n.nationality) LIKE LOWER(CONCAT('%', :query,'%'))
			""")
	List<Book> search(@Param("query") String query);
	
	@Modifying
	@Transactional
	@Query(
	    value = """
	    	UPDATE tbl_book SET b_status=0
	    	WHERE i_id_book=:id
	        """,
	    nativeQuery = true
	)
	int updateBookStatus(
	    @Param("id") Long id
	);
}
