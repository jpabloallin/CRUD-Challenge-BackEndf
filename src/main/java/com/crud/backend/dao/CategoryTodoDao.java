package com.crud.backend.dao;

import com.crud.backend.entity.Category;
import com.crud.backend.entity.Todo;

import java.util.List;

public interface CategoryTodoDao {

        List<Category> findAllCategories();

        Category createCategory(Category category);

        Category createTodo(Todo todo);

        Category updateTodo(Todo todo);

        void deleteCategory(Category category);

        void deleteTodo(Todo todo);

}
