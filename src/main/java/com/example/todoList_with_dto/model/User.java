package com.example.todoList_with_dto.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
}
