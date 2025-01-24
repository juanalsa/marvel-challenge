package com.test.api.marvel_challenge.service;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ComicDto;

import java.util.List;

public interface ComicService {
    List<ComicDto> findAll(MyPageable myPageable, Long characterId);

    ComicDto findById(Long comicId);
}
