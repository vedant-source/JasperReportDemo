package com.jasper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jasper.dto.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
