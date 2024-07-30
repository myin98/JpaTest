package com.app.Service;

import com.app.dto.TestDTO;
import com.app.entity.Board;

public interface BoardService {

	public TestDTO findList(String accept);
	public TestDTO fineOne(int no);
	public TestDTO save(Board board);
	public TestDTO accept(int no, boolean accept);
	
}
