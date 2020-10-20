package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer>
{
	

}
