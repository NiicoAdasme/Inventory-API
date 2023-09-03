package com.company.inventory.Services;

import com.company.inventory.DAO.ICategoryDao;
import com.company.inventory.Model.Category;
import com.company.inventory.Response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService{

    @Autowired
    private ICategoryDao categoryDao;
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {

        CategoryResponseRest responseRest = new CategoryResponseRest();

        try {
            List<Category> categories = (List<Category>) categoryDao.findAll();

            responseRest.getCategoryResponse().setCategories(categories);
            responseRest.setMetadata("Respuesta OK", "00", "Respuesta exitosa");

        }catch (Exception e){
            responseRest.setMetadata("Respuesta NO OK", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.OK);
    }
}
