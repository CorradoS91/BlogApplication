package it.corrado.controller;

import it.corrado.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
public interface PostController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto getPostById(@PathVariable(name="id")Long id);
    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    PostDto getPostByTitle(@PathVariable(name="title")String title);
    @GetMapping("/subtitle/{subtitle}")
    @ResponseStatus(HttpStatus.OK)
    PostDto getPostBySubtitle(@PathVariable(name="subtitle")String subtitle);
    @PostMapping("/create/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    PostDto createPost(@PathVariable(name="userId")Long userId, @RequestBody PostDto postDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PostDto updatePost(@PathVariable(name="id") Long id,@RequestBody PostDto postDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable(name="id")Long id);
    @PostMapping("/{postId}/tags/{tagId}")
    @ResponseStatus(HttpStatus.CREATED)
    PostDto addTagToPost(@PathVariable(name="postId") Long postId, @PathVariable(name="tagId") Long tagId);

}
