package com.crud.backend.dao;

import com.crud.backend.entity.Category;
import com.crud.backend.entity.Todo;
import com.crud.backend.repository.CategoryRepository;
import com.crud.backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryTodoDaoImplement implements CategoryTodoDao {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category createTodo(Todo todo) {
        Long categoryId = todo.getFkCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        category.addTodo(todo);
        todoRepository.save(todo);
        return categoryRepository.save(category);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
