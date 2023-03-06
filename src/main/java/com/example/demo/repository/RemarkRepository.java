package com.example.demo.repository;


import com.example.demo.entity.Remark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemarkRepository extends JpaRepository<Remark, Long> {

    List<Remark> findAllBycId(Long cId);
}