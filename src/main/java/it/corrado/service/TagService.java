package it.corrado.service;

import it.corrado.dto.TagDto;

public interface TagService {
    TagDto createTag(TagDto tagDto);
    TagDto getTagById(long id);
    TagDto updateTag(TagDto tagDto, long id);
    void deleteTag(long id);
}
