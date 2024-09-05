package it.corrado.service;

import it.corrado.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePost(long id);
}
