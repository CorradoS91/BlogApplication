package it.corrado.mapper;

import it.corrado.dto.TagDto;
import it.corrado.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TagMapper {
    TagDto tagToTagDto (Tag tag);
    Tag tagDtoToTag(TagDto tagDto);
}
