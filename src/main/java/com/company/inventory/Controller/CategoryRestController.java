package com.company.inventory.Controller;

import com.company.inventory.Response.CategoryResponseRest;
import com.company.inventory.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

//    Get All the categories
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {

        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

//    Get categories by ID
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoriesById(@PathVariable Long id) {
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }
}
