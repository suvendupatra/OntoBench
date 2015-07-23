package de.linkvt.bachelor.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for accessing a stored generation.
 */
public interface StoredGenerationRepository extends CrudRepository<StoredGeneration, Long> {
}
