package com.company.inventory.DAO;

import com.company.inventory.Model.Category;
import org.springframework.data.repository.CrudRepository;

// DAO = Data Access Object
public interface ICategoryDao extends CrudRepository<Category, Long> {


}
