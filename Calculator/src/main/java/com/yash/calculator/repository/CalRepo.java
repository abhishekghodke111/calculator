package com.yash.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.calculator.model.Numbers;

@Repository
public interface CalRepo extends JpaRepository<Numbers, Integer> {

}
