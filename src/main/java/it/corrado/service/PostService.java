package it.corrado.service;

import it.corrado.dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long id);
    PostDto getPostByTitle(String title);
    PostDto getPostBySubtitle(String subtitle);
    PostDto updatePost(PostDto postDto, Long id);
    void deletePost(Long id);
}
