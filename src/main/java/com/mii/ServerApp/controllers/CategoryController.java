package com.mii.ServerApp.controllers;

import com.mii.ServerApp.models.Category;
import com.mii.ServerApp.services.CategoryService;
import java.util.List;
import lombok.AllArgsConstructor;

// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

  private CategoryService categoryService;

  // @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping
  public List<Category> getAll() {
    return categoryService.getAll();
  }
  
  // @PreAuthorize("hasAnyAuthority('READ_ADMIN', 'READ_USER')")
  @GetMapping("/{id}")
  public Category getById(@PathVariable Integer id) {
    return categoryService.getById(id);
  }

  // @PreAuthorize("hasAuthority('CREATE_ADMIN')")
  @PostMapping
  public Category create(@RequestBody Category category) {
    return categoryService.create(category);
  }

  // @PreAuthorize("hasAuthority('UPDATE_ADMIN')")
  @PutMapping("/{id}")
  public Category update(
    @PathVariable Integer id,
    @RequestBody Category category
  ) {
    return categoryService.update(id, category);
  }

  // @PreAuthorize("hasAuthority('DELETE_ADMIN')")
  @DeleteMapping("/{id}")
  public Category delete(@PathVariable Integer id) {
    return categoryService.delete(id);
  }
}
