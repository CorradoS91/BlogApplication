package it.corrado.controller.impl;

import it.corrado.controller.PostController;
import it.corrado.dto.PostDto;
import it.corrado.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostControllerImpl implements PostController {
    @Autowired
    private final PostService postService;
    @Override
    public PostDto getPostById(Long id) {
        return postService.getPostById(id);
    }

    @Override
    public PostDto getPostByTitle(String title) {
        return postService.getPostByTitle(title);
    }

    @Override
    public PostDto getPostBySubtitle(String subtitle) {
        return postService.getPostBySubtitle(subtitle);
    }


    @Override
    public PostDto createPost(PostDto postDto) {
        return postService.createPost(postDto);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        return postService.updatePost(postDto,id);
    }

    @Override
    public void deletePost(Long id) {
        postService.deletePost(id);
    }
}
