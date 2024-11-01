package org.yalli.wah.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.yalli.wah.model.dto.CommentAddDto;
import org.yalli.wah.model.dto.MentorDetailDto;
import org.yalli.wah.model.enums.MentorCategory;
import org.yalli.wah.model.dto.MentorSearchDto;
import org.yalli.wah.service.CommentService;
import org.yalli.wah.service.MentorService;

import java.util.List;
@RestController
@RequestMapping("/v1/mentors")
@CrossOrigin
@RequiredArgsConstructor
public class MentorController {
    private final MentorService mentorService;
    private final CommentService commentService;

    @GetMapping("/search")
    @Operation(summary = "search mentors")
    @ResponseStatus(HttpStatus.OK)
    public Page<MentorSearchDto> search(@RequestParam(required = false) String fullName,
                                        @RequestParam(required = false) String country,
                                        @RequestParam(required = false) List<MentorCategory> mentorCategory,
                                        Pageable pageable) {
        return mentorService.searchMembers(fullName, country, mentorCategory, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get mentor with its info and comments")
    public MentorDetailDto getMentor(Pageable pageable,
                                           @PathVariable Long id){
        return mentorService.getMentorById(id,pageable);
    }

    @PostMapping("/{id}/comment")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add comment about the mentor")
    public void addComment(@RequestBody CommentAddDto commentAddDto){
        commentService.addComment(commentAddDto);
    }
}

