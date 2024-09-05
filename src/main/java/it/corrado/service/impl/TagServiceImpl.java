package it.corrado.service.impl;

import it.corrado.dto.TagDto;
import it.corrado.mapper.TagMapper;
import it.corrado.model.Tag;
import it.corrado.repository.TagRepository;
import it.corrado.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    @Autowired
    private final TagRepository tagRepository;
    @Autowired
    private final TagMapper tagMapper;
    @Override
    public TagDto createTag(TagDto tagDto) {
        Tag tag = tagMapper.tagDtoToTag(tagDto);
        tagRepository.save(tag);
        return tagMapper.tagToTagDto(tag);
    }

    @Override
    public TagDto getTagById(long id) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        return tagMapper.tagToTagDto(tag);
    }

    @Override
    public TagDto updateTag(TagDto tagDto, long id) {
        Tag oldTag = tagRepository.findById(id).orElseThrow();
        Tag updatedTag = tagMapper.tagDtoToTag(tagDto);
        tagMapper.updateTag(oldTag,updatedTag);
        return tagMapper.tagToTagDto(updatedTag);
    }

    @Override
    public void deleteTag(long id) {
        tagRepository.findById(id).orElseThrow();
    }
}
