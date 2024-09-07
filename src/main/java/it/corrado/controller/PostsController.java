package it.corrado.controller;

import it.corrado.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
@RequestMapping("/posts")
public interface PostsController {
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<PostDto> getAllPosts();
}
