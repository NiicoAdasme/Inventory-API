package com.company.inventory.Services;

import com.company.inventory.DAO.ICategoryDao;
import com.company.inventory.Model.Category;
import com.company.inventory.Response.CategoryResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {

        CategoryResponseRest responseRest = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {

            Optional<Category> category = categoryDao.findById(id);

            if (category.isPresent()) {
                list.add(category.get());
                responseRest.getCategoryResponse().setCategories(list);
                responseRest.setMetadata("Respuesta OK", "00", "Categoria encontrada");
            } else {
                responseRest.setMetadata("Respuesta NO OK", "-1", "Categoria no encontrada");
                return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            responseRest.setMetadata("Respuesta NO OK", "-1", "Error al consultar por ID");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {

        CategoryResponseRest responseRest = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            Category categorySaved = categoryDao.save(category);

            if (categorySaved != null) {
                list.add(categorySaved);
                responseRest.getCategoryResponse().setCategories(list);
                responseRest.setMetadata("Respuesta OK", "00", "Categoria guardada");
            } else {
                responseRest.setMetadata("Respuesta NO OK", "-1", "Categoria no guardada");
                return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            responseRest.setMetadata("Respuesta NO OK", "-1", "Error al guardar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new  ResponseEntity<CategoryResponseRest>(responseRest, HttpStatus.OK);
    }
}
