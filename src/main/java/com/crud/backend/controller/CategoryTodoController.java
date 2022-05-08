package com.crud.backend.controller;

import com.crud.backend.entity.Category;
import com.crud.backend.entity.Todo;
import com.crud.backend.service.CategoryTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryTodoController {
        @Autowired
        private CategoryTodoService service;

        @GetMapping("get/categories")
        public List<Category> findAllCategories(){
            return service.findAllCategories();
        }

        @PostMapping("create/category")
        public Category createCategory(@Valid @RequestBody Category category){
            return service.createCategory(category);
        }

        @PostMapping("create/todo")
        public Category createNote(@Valid @RequestBody Todo todo){
            return service.createTodo(todo);
        }

        @PutMapping("update/todo")
        public Todo updateNote(@RequestBody Todo todo){
            return service.updateTodo(todo);
        }

        @CrossOrigin
        @DeleteMapping("delete/category/{id}")
        public void deleteCategory(@PathVariable Long id){
            service.deleteCategory(id);
        }
        @CrossOrigin
        @DeleteMapping("delete/todo/{id}")
        public void deleteNote(@PathVariable Long id){
            service.deleteTodo(id);
        }
}
