package com.tan.app.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardDTO { // VO
	private int boardId; // PK
	private String memberId; // FK
	@NotBlank(message="Null 및 공백 안됨")
	private String content;
}
