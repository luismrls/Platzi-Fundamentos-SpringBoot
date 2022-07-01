package com.fundamentos.springboot.fundamentos.repository;


import com.fundamentos.springboot.fundamentos.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<PostUser, Long> {
}
