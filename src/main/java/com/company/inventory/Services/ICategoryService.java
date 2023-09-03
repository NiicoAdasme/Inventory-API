package com.company.inventory.Services;

import com.company.inventory.Model.Category;
import com.company.inventory.Response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    public ResponseEntity<CategoryResponseRest> search();
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
    public ResponseEntity<CategoryResponseRest> save(Category category);
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id);
    public ResponseEntity<CategoryResponseRest> deleteById(Long id);

}
