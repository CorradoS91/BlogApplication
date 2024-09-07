package it.corrado.service.impl;

import it.corrado.dto.PostDto;
import it.corrado.exception.NotFoundException;
import it.corrado.mapper.PostMapper;
import it.corrado.model.Post;
import it.corrado.model.Tag;
import it.corrado.model.User;
import it.corrado.repository.PostRepository;
import it.corrado.repository.TagRepository;
import it.corrado.repository.UserRepository;
import it.corrado.service.PostService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final PostMapper postMapper;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final TagRepository tagRepository;

    @Override
    @Transactional
    public PostDto createPost(Long userId,PostDto postDto) {
        User user = userRepository.findById(userId).orElseThrow(()->buildNotFoundException(userId,null,null));
        Post post = postMapper.postDtoToPost(postDto);
        post.setUser(user);
        postRepository.save(post);
        PostDto resultDto = postMapper.postToPostDto(post);
        resultDto.setFkUserID(userId);
        return resultDto;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        PostDto resultDto = postMapper.postToPostDto(post);
        resultDto.setFkUserID(id);
        return resultDto;
    }

    @Override
    public PostDto getPostByTitle(String title) {
        Post post = postRepository.getPostByTitle(title).orElseThrow(()->buildNotFoundException(null,title,null));
        return postMapper.postToPostDto(post);
    }

    @Override
    public PostDto getPostBySubtitle(String subtitle) {
        Post post = postRepository.getPostBySubtitle(subtitle).orElseThrow(()->buildNotFoundException(null,null,subtitle));
        return postMapper.postToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post oldPost = postRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        postMapper.updatePost(postDto, oldPost);
        postRepository.save(oldPost);
        return postMapper.postToPostDto(oldPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> tagList = postRepository.findAll();
        return postMapper.listPostDtoToList(tagList);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null,null));
        postRepository.deleteById(id);
    }
    @Override
    public PostDto addTagToPost(Long postId, Long tagId) {
        Post post = postRepository.findById(postId).orElseThrow(()->buildNotFoundException(postId,null,null));
        Tag tag = tagRepository.findById(tagId).orElseThrow(()->buildNotFoundException(tagId,null,null));
        post.getTagSet().add(tag);
        postRepository.save(post);
        PostDto tempDto = postMapper.postToPostDto(post);
        tempDto.getTagIds().add(tagId);
        return tempDto;
    }


    private RuntimeException buildNotFoundException(Long id,String title,String subtitle) {
        NotFoundException exception = new NotFoundException();
        exception.setIdNotFound(id);
        exception.setEmailNotFound(title);
        exception.setNicknameNotFound(subtitle);
        if(id!=null){
            String ms ="The following Id was not found: %d";
            exception.setMessage(String.format(ms,id));
            return exception;
        }
        if(title!=null) {
            String ms ="The following Title was not found: %s";
            exception.setMessage(String.format(ms,title));
            return exception;
        }
        if(subtitle!=null) {
            String ms ="The following Subtitle was not found: %s";
            exception.setMessage(String.format(ms,subtitle));
            return exception;
        }
        return null;
    }
}
