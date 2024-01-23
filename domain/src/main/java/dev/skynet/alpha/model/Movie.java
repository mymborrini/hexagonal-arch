package dev.skynet.alpha.model;

import lombok.With;

import java.util.Date;

@With
public record Movie(
        Long id,
        String title,
        String description,
        String directorName,
        Date creationDatetime,
        Date lastUpdateDatetime
) {
}
