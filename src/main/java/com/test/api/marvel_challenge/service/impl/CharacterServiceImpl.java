package com.test.api.marvel_challenge.service.impl;

import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.CharacterDto;
import com.test.api.marvel_challenge.persistence.integration.marvel.repository.CharacterRepository;
import com.test.api.marvel_challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDto> findAll(MyPageable myPageable, String name, int[] comics, int[] series) {
        return characterRepository.findAll(myPageable, name, comics, series);
    }

    @Override
    public CharacterDto.CharacterInfoDto findInfoById(Long characterId) {
        return characterRepository.findInfoById(characterId);
    }
}
