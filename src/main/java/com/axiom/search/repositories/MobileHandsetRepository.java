package com.axiom.search.repositories;

import com.axiom.search.repositories.entities.MobileHandsetEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MobileHandsetRepository extends MongoRepository<MobileHandsetEntity, Integer> {

}
