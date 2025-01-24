package com.test.api.marvel_challenge.persistence.integration.marvel.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.CharacterDto;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ThumbnailDto;

import java.util.ArrayList;
import java.util.List;

public class CharacterMapper {

    public static List<CharacterDto> toDtoList(JsonNode rootNode) {
        ArrayNode resultsNode = getResultsNode(rootNode);

        List<CharacterDto> characters = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            characters.add(CharacterMapper.toDto(each));
        });

        return characters;
    }

    private static CharacterDto toDto(JsonNode characterNode) {
        if (characterNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        CharacterDto characterDto = new CharacterDto(
                characterNode.get("id").asLong(),
                characterNode.get("name").asText(),
                characterNode.get("description").asText(),
                characterNode.get("modified").asText(),
                characterNode.get("resourceURI").asText()
        );

        return characterDto;
    }

    private static ArrayNode getResultsNode(JsonNode rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        JsonNode dataNode = rootNode.get("data");
        return (ArrayNode) dataNode.get("results");
    }

    public static List<CharacterDto.CharacterInfoDto> toInfoDtoList(JsonNode response) {
        ArrayNode resultsNode = getResultsNode(response);

        List<CharacterDto.CharacterInfoDto> charactersInfo = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            charactersInfo.add(CharacterMapper.toInfoDto(each));
        });

        return charactersInfo;
    }

    private static CharacterDto.CharacterInfoDto toInfoDto(JsonNode characterNode) {
        if (characterNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        JsonNode thumbnailNode = characterNode.get("thumbnail");
        ThumbnailDto thumbnailDto = ThumbnailMapper.toDto(thumbnailNode);
        String imagePath = thumbnailDto.path() + "." + thumbnailDto.extension();

        CharacterDto.CharacterInfoDto characterInfoDto = new CharacterDto.CharacterInfoDto(
                imagePath,
                characterNode.get("description").asText()
        );

        return characterInfoDto;
    }
}
