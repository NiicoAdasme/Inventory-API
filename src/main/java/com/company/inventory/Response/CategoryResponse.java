package com.company.inventory.Response;

import com.company.inventory.Model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {

    private List<Category> categories;
}
