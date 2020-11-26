package com.miluyas.repository;

import com.miluyas.entity.Order;
import java.util.List;

public interface OrderRepository {
    public List<Order> findAll(int index, int limit);
    public int count();
    public Order findById(long id);
    public void save(Order order);
    public void update(Order order);
    public void deleteById(long id);

}
