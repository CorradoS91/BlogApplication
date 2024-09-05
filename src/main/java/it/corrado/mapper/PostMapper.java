package it.corrado.mapper;

import it.corrado.dto.PostDto;
import it.corrado.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostMapper {
    PostDto postToPostDto (Post post);
    Post postDtoToPost(PostDto postDto);
    void updatePost(PostDto postDto, @MappingTarget Post post);
}
