package it.corrado.mapper;

import it.corrado.dto.TagDto;
import it.corrado.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TagMapper {
    TagDto tagToTagDto (Tag tag);
    Tag tagDtoToTag(TagDto tagDto);
    List<TagDto> listTagDtoToList(List<Tag> tag);
    void updateTag(TagDto tagDto, @MappingTarget Tag tag);
}
