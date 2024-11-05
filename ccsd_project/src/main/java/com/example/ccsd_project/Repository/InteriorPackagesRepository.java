package com.example.ccsd_project.Repository;
import com.example.ccsd_project.Model.ServicePackage.InteriorPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorPackagesRepository extends JpaRepository<InteriorPackages, Long> {
}
