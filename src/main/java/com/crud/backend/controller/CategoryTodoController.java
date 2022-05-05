package com.crud.backend.controller;

import com.crud.backend.entity.Category;
import com.crud.backend.entity.Todo;
import com.crud.backend.service.CategoryTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        public Category createCategory(@RequestBody Category category){
            return service.createCategory(category);
        }

        @PostMapping("create/todo")
        public Category createNote(@RequestBody Todo todo){
            return service.createTodo(todo);
        }

        @PutMapping("update/todo")
        public Category updateNote(@RequestBody Todo todo){
            return service.createTodo(todo);
        }

        @DeleteMapping("delete/category")
        public void deleteCategory(@RequestBody Category category){
            service.deleteCategory(category);
        }

        @DeleteMapping("delete/todo")
        public void deleteNote(@RequestBody Todo todo){
            service.deleteTodo(todo);
        }
}
