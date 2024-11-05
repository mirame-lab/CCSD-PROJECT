package com.example.ccsd_project.Repository;

import com.example.ccsd_project.Model.ServicePackage.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
