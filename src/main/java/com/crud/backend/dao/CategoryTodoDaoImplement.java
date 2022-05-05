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
    public Category updateTodo(Todo todo) {
        Long categoryId = todo.getFkCategoryId();
        Category category = categoryRepository.findById(categoryId).get();
        if(category != null){
            for(Integer i = 0; i < category.getTodos().size(); i++){
                if(todo.getId().equals(category.getTodos().get(i))){
                    category.getTodos().set(i, todo);
                }
            }
        }
        todoRepository.save(todo);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        Category categoryToBeDeleted = categoryRepository.findById(category.getId()).get();
        if(categoryToBeDeleted.getTodos().size() >= 0) {
            categoryToBeDeleted.getTodos().forEach(todo -> todoRepository.deleteById(todo.getId()));
        }
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepository.deleteById(todo.getId());
    }
}
