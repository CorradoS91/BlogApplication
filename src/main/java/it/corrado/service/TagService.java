package it.corrado.service;

import it.corrado.dto.TagDto;

public interface TagService {
    TagDto createTag(TagDto tagDto);
    TagDto getTagById(Long id);
    TagDto getTagByName(String name);
    TagDto updateTag(TagDto tagDto, Long id);
    void deleteTag(Long id);
}
