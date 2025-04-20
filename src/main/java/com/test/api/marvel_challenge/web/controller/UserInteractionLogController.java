package com.test.api.marvel_challenge.web.controller;

import com.test.api.marvel_challenge.dto.GetUserInteractionLogDto;
import com.test.api.marvel_challenge.service.UserInteractionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users-interactions")
public class UserInteractionLogController {

    @Autowired
    private UserInteractionLogService userInteractionLogService;

    @GetMapping
    public ResponseEntity<Page<GetUserInteractionLogDto>> findAll(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit
    ) {
        Pageable pageable = buildPageable(offset, limit);

        return ResponseEntity.ok(userInteractionLogService.findAll(pageable));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Page<GetUserInteractionLogDto>> findByUsername(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit
    ) {
        Pageable pageable = buildPageable(offset, limit);

        return ResponseEntity.ok(userInteractionLogService.findByUsername(pageable, username));
    }

    private static Pageable buildPageable(int offset, int limit) {
        Pageable pageable = null;

        if (offset < 0) {
            throw new IllegalArgumentException("Offset must be greater than or equal to 0");
        }

        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }

        if (offset == 0)
            pageable = PageRequest.of(offset, limit);
        else
            pageable = PageRequest.of(offset / limit, limit);
        return pageable;
    }

}
