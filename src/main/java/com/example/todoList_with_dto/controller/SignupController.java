package com.example.todoList_with_dto.controller;

import com.example.todoList_with_dto.dto.SignupDto;
import com.example.todoList_with_dto.model.User;
import com.example.todoList_with_dto.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("signupDto", new SignupDto());

        return "signup";
    }

    @PostMapping("/signup")
    public String doSignup(@Valid @ModelAttribute SignupDto signupDto,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (userRepository.findByUsername(signupDto.getUsername()) != null) {
            model.addAttribute("error", "이미 사용 중인 아이디입니다");

            return "signup";
        }

        User user = User.builder()
                .username(signupDto.getUsername())
                .password(signupDto.getPassword())
                .build();

        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
