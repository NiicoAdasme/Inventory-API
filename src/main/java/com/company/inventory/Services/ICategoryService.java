package com.company.inventory.Services;

import com.company.inventory.Response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    public ResponseEntity<CategoryResponseRest> search();
    public ResponseEntity<CategoryResponseRest> searchById(Long id);

}
