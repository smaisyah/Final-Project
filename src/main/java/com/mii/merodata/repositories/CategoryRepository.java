package com.mii.merodata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name = ?1") // casesensitive
    public List<Category> searchByName(String name);

    // Native
    @Query(value = "SELECT * FROM CATEGORIES WHERE NAME = :name", // incasesensitive
            nativeQuery = true)
    public List<Category> searchByNameNative(String name);

    Category findByName(String name);
}
