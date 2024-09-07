package it.corrado.controller.impl;

import it.corrado.controller.PostsController;
import it.corrado.dto.PostDto;
import it.corrado.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsControllerImpl implements PostsController {
    @Autowired
    private final PostService postService;
    @Override
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
}
