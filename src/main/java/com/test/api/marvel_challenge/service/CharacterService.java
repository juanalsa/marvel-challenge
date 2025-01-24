package com.test.api.marvel_challenge.service;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.CharacterDto;

import java.util.List;

public interface CharacterService {

    List<CharacterDto> findAll(MyPageable myPageable, String name, int[] comics, int[] series);

    CharacterDto.CharacterInfoDto findInfoById(Long characterId);
}
