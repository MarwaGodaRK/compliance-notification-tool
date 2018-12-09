package com.crossover.compliance.repository;

import com.crossover.compliance.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Spring Data MongoDB repository for the Authority entity.
 */
public interface UserRepository extends MongoRepository<User, Integer> {
}
