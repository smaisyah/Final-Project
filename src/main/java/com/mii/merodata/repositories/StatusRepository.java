package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
