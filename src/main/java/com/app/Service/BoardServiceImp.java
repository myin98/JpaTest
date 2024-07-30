package com.app.Service;

import org.springframework.stereotype.Service;

import com.app.dto.TestDTO;
import com.app.entity.Board;
import com.app.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService {

	private final BoardRepository BR;
	private TestDTO dto;
	
	@Override
	public TestDTO findList(String accept) {
		dto = TestDTO.builder().build();
		dto.setStatus(true);
		dto.setMessage("성공");
		if(accept != null) {
			dto.setResult(BR.findByAccept(("1".equals(accept)? true : false)));
		} else {
			dto.setResult(BR.findAll());
		}
		
		return dto;
	}

	@Override
	public TestDTO fineOne(int no) {
		dto = TestDTO.builder().build();
		dto.setStatus(true);
		dto.setMessage("성공");
		dto.setResult(BR.findById(no));
		return dto;
	}

	@Override
	public TestDTO save(Board board) {
		dto = TestDTO.builder().build();
		dto.setStatus(true);
		dto.setMessage("성공");
		dto.setResult(BR.save(board));
		return dto;
	}

	@Override
	public TestDTO accept(int no, boolean accept) {
		Board bd = BR.findById(no).orElseThrow();
		bd.setAccept(accept);
		return save(bd);
	}
	
}
