package it.corrado.controller;

import it.corrado.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tag")
public interface PostController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto getPostById(@PathVariable(name="id")long id);
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PostDto createPost(@RequestBody PostDto postDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto updatePost(@PathVariable(name="id") long id,@RequestBody PostDto postDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable(name="id")long id);
}
