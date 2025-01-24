package com.test.api.marvel_challenge.persistence.integration.marvel.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.test.api.marvel_challenge.persistence.integration.marvel.dto.ThumbnailDto;

public class ThumbnailMapper {

    public static ThumbnailDto toDto(JsonNode thumbnailNode) {
        if (thumbnailNode == null) {
            throw new IllegalArgumentException("El nodo JSON no puede ser null");
        }

        ThumbnailDto thumbnailDto = new ThumbnailDto(
                thumbnailNode.get("path").asText(),
                thumbnailNode.get("extension").asText()
        );

        return thumbnailDto;
    }
}
