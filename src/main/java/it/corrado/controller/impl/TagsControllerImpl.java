package it.corrado.controller.impl;

import it.corrado.controller.TagsController;
import it.corrado.dto.TagDto;
import it.corrado.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagsControllerImpl implements TagsController {
    @Autowired
    private final TagService tagService;
    @Override
    public List<TagDto> getAllTags() {
        return tagService.getAllTags();
    }
}
