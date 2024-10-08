package it.corrado.controller;

import it.corrado.dto.TagDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tag")
public interface TagController {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TagDto getTagById(@PathVariable(name="id")Long id);
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    TagDto getTagByName(@PathVariable(name="name")String name);
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TagDto createTag(@RequestBody TagDto tagDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TagDto updateTag(@PathVariable(name="id") Long id,@RequestBody TagDto tadDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTag(@PathVariable(name="id")Long id);
}
