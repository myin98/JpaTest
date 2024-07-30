package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	@Query
	List<Board> findByAccept(boolean accept);
	
}
