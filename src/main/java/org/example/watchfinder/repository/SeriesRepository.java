package org.example.watchfinder.repository;

import org.example.watchfinder.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SeriesRepository extends MongoRepository<Series, String> {
    Optional<Series> findBy_id(String id);
}
