package org.example.service;

import java.util.List;

public interface BaseService<T> {
    public T getById(int id);
    public void add(T item);

    public List<T> getList();
    public void delete(T item);
}
