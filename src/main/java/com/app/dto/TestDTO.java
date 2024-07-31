package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {

	private boolean status;	//성공 여부 확인
	private String message;	//오류 로그 확인
	private Object Result;	//객체를 담아줄 오브젝트
	
}
