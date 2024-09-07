package it.corrado.service;

import it.corrado.dto.TagDto;

import java.util.List;

public interface TagService {
    TagDto createTag(TagDto tagDto);
    TagDto getTagById(Long id);
    TagDto getTagByName(String name);
    TagDto updateTag(TagDto tagDto, Long id);
    List<TagDto> getAllTags();
    void deleteTag(Long id);
}
