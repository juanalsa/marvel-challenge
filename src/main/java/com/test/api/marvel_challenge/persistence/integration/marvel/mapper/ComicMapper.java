package com.test.api.marvel_challenge.persistence.integration.marvel.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ComicDto;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ThumbnailDto;

import java.util.ArrayList;
import java.util.List;

public class ComicMapper {

    public static List<ComicDto> toDtoList(JsonNode rootNode) {
        ArrayNode resultsNode = getResultsNode(rootNode);

        List<ComicDto> comics = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            comics.add(ComicMapper.toDto(each));
        });

        return comics;
    }

    private static ComicDto toDto(JsonNode comicNode) {
        if (comicNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        JsonNode thumbnailNode = comicNode.get("thumbnail");
        ThumbnailDto thumbnailDto = ThumbnailMapper.toDto(thumbnailNode);

        ComicDto comicDto = new ComicDto(
                comicNode.get("id").asLong(),
                comicNode.get("title").asText(),
                comicNode.get("description").asText(),
                comicNode.get("modified").asText(),
                comicNode.get("resourceURI").asText(),
                thumbnailDto
        );

        return comicDto;
    }

    private static ArrayNode getResultsNode(JsonNode rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        JsonNode dataNode = rootNode.get("data");
        return (ArrayNode) dataNode.get("results");
    }
}
