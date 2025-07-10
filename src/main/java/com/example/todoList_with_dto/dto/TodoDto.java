package com.example.todoList_with_dto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
    private Integer id;
    private boolean completed;

    @NotBlank(message = "제목을 입력하세요")
    private String title;

}
