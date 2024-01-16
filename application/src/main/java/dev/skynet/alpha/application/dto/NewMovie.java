package dev.skynet.alpha.application.dto;

import lombok.With;

@With
public record NewMovie(
        String title,
        String description,
        String directorName
) {
}
