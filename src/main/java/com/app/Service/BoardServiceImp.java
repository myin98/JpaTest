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
		dto = TestDTO.builder().status(true).message("성공").build();
		if(accept != null) {
			dto.setResult(BR.findByAccept(("1".equals(accept)? true : false)));
		} else {
			dto.setResult(BR.findAll());
		}
		return dto;
	}

	@Override
	public TestDTO fineOne(int no) {
		return TestDTO.builder()
				.status(true)
				.message("성공")
				.Result(BR.findById(no))
				.build();
	}

	@Override
	public TestDTO save(Board board) {
		return TestDTO.builder()
				.status(true).message("성공")
				.Result(BR.save(board))
				.build();
	}

	@Override
	public TestDTO accept(int no, boolean accept) {
		Board bd = BR.findById(no).orElseThrow();
		bd.setAccept(accept);
		return save(bd);
	}
	
}
