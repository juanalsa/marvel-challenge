package com.test.api.marvel_challenge.persistence.integration.marvel.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.api.marvel_challenge.dto.MyPageable;
import com.test.api.marvel_challenge.persistence.integration.marvel.mapper.CharacterMapper;
import com.test.api.marvel_challenge.persistence.integration.marvel.MarvelAPIConfig;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.CharacterDto;
import com.test.api.marvel_challenge.service.HttpClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Repository
public class CharacterRepository {

    @Autowired
    private MarvelAPIConfig marvelAPIConfig;

    @Autowired
    private HttpClientService httpClientService;

    @Value("${integration.marvel.base-path}")
    private String basePath;
    private String characterPath;

    @PostConstruct
    private void setPath() {
        characterPath = basePath.concat("/").concat("characters");
    }

    public List<CharacterDto> findAll(MyPageable myPageable, String name, int[] comics, int[] series) {
        Map<String, String> marvelQueryParams = getQueryParamsForFindAll(myPageable, name, comics, series);
        JsonNode response = httpClientService.doGet(characterPath, marvelQueryParams, JsonNode.class);
        return CharacterMapper.toDtoList(response);
    }

    private Map<String, String> getQueryParamsForFindAll(MyPageable myPageable, String name, int[] comics, int[] series) {
        Map<String, String> marvelQueryParams = marvelAPIConfig.getAuthenticationQueryParams();
        marvelQueryParams.put("offset", Long.toString(myPageable.offset()));
        marvelQueryParams.put("limit", Long.toString(myPageable.limit()));

        if (StringUtils.hasText(name)) {
            marvelQueryParams.put("name", name);
        }

        if (comics != null) {
            String comicsAsString = this.joinIntArray(comics);
            marvelQueryParams.put("comics", comicsAsString);
        }

        if (series != null) {
            String seriesAsString = this.joinIntArray(series);
            marvelQueryParams.put("series", seriesAsString);
        }

        return marvelQueryParams;
    }

    private String joinIntArray(int[] data) {
        List<String> stringArray = IntStream.of(data).boxed()
                .map(Object::toString)
                .toList();

        return String.join(",", stringArray);
    }

    public CharacterDto.CharacterInfoDto findInfoById(Long characterId) {
        Map<String, String> marvelQueryParams = marvelAPIConfig.getAuthenticationQueryParams();

        String finalUrl = characterPath.concat("/").concat(Long.toString(characterId));
        JsonNode response = httpClientService.doGet(finalUrl, marvelQueryParams, JsonNode.class);

        return CharacterMapper.toInfoDtoList(response).get(0);
    }
}
