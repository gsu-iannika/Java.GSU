package com.by.gsu.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.by.gsu.pms.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
