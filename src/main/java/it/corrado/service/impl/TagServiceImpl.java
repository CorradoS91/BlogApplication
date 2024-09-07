package it.corrado.service.impl;

import it.corrado.dto.TagDto;
import it.corrado.exception.NotFoundException;
import it.corrado.mapper.TagMapper;
import it.corrado.model.Tag;
import it.corrado.repository.TagRepository;
import it.corrado.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public TagDto getTagById(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null));
        return tagMapper.tagToTagDto(tag);
    }

    @Override
    public TagDto getTagByName(String name) {
        Tag tag = tagRepository.getTagByName(name).orElseThrow(()->buildNotFoundException(null,name));
        return tagMapper.tagToTagDto(tag);
    }

    @Override
    public TagDto updateTag(TagDto tagDto, Long id) {
        Tag oldTag = tagRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null));
        tagMapper.updateTag(tagDto,oldTag);
        tagRepository.save(oldTag);
        return tagMapper.tagToTagDto(oldTag);
    }

    @Override
    public List<TagDto> getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        return tagMapper.listTagDtoToList(tagList);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.findById(id).orElseThrow(()->buildNotFoundException(id,null));
        tagRepository.deleteById(id);
    }
    private RuntimeException buildNotFoundException(Long id,String name) {
        NotFoundException exception = new NotFoundException();
        exception.setIdNotFound(id);
        exception.setEmailNotFound(name);
        if(id!=null){
            String ms ="The following Id was not found: %d";
            exception.setMessage(String.format(ms,id));
            return exception;
        }
        if(name!=null) {
            String ms ="The following Name was not found: %s";
            exception.setMessage(String.format(ms,name));
            return exception;
        }
        return null;
    }
}
