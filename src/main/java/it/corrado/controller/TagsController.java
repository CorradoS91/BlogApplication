package it.corrado.controller;

import it.corrado.dto.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/tags")
public interface TagsController {
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<TagDto> getAllTags();
}
