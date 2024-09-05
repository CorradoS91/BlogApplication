package it.corrado.controller.impl;

import it.corrado.controller.TagController;
import it.corrado.dto.TagDto;
import it.corrado.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagControllerImpl implements TagController {
    @Autowired
    private final TagService tagService;
    @Override
    public TagDto getTagById(long id) {
        return tagService.getTagById(id);
    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @Override
    public TagDto updateTag(long id, TagDto tagDto) {
        return tagService.updateTag(tagDto,id);
    }

    @Override
    public void deleteTag(long id) {
        tagService.deleteTag(id);
    }
}
