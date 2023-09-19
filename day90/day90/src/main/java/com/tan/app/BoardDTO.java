package com.tan.app;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BoardDTO { // VO
	private int boardId; // PK
	private String memberId; // FK
	@NotNull(message="글 내용 Null")
	@NotEmpty(message="글 내용 Empty")
	private String content;
}
