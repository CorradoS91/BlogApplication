package it.corrado.service.impl;

import it.corrado.dto.PostDto;
import it.corrado.mapper.PostMapper;
import it.corrado.model.Post;
import it.corrado.repository.PostRepository;
import it.corrado.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final PostMapper postMapper;
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.postDtoToPost(postDto);
        postRepository.save(post);
        return postMapper.postToPostDto(post);
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return postMapper.postToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post oldPost = postRepository.findById(id).orElseThrow();
        postMapper.updatePost(postDto, oldPost);
        postRepository.save(oldPost);
        return postMapper.postToPostDto(oldPost);
    }

    @Override
    public void deletePost(long id) {
        postRepository.findById(id).orElseThrow();
        postRepository.deleteById(id);
    }
}
