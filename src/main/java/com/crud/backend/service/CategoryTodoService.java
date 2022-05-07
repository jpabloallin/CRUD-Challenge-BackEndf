package com.crud.backend.service;

import com.crud.backend.dao.CategoryTodoDaoImplement;
import com.crud.backend.entity.Category;
import com.crud.backend.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTodoService {

    @Autowired
    private CategoryTodoDaoImplement categoryTodoService;

    public List<Category> findAllCategories(){
        return categoryTodoService.findAllCategories();
    }

    public Category createCategory(Category category){
        return categoryTodoService.createCategory(category);
    }

    public Category createTodo(Todo todo){
        return categoryTodoService.createTodo(todo);
    }

    public Todo updateTodo(Todo todo){
        return categoryTodoService.updateTodo(todo);
    }

    public void deleteCategory(Category category){
        categoryTodoService.deleteCategory(category);
    }

    public void deleteTodo(Todo todo){
        categoryTodoService.deleteTodo(todo);
    }

}
