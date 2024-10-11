package com.lets.cook.demo.repository;

import com.lets.cook.demo.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("""
            SELECT r
            FROM Recipe r WHERE r.recipeName LIKE %:name%
            """)
    Page<Recipe> findByNameLike(String name, Pageable pageable);
}
