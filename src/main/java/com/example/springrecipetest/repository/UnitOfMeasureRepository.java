package com.example.springrecipetest.repository;

import com.example.springrecipetest.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<Category, Long> {
}
