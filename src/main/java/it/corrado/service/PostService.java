package it.corrado.service;

import it.corrado.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(Long userId,PostDto postDto);
    PostDto getPostById(Long id);
    PostDto getPostByTitle(String title);
    PostDto getPostBySubtitle(String subtitle);
    PostDto updatePost(PostDto postDto, Long id);
    List<PostDto> getAllPosts();
    void deletePost(Long id);
}
