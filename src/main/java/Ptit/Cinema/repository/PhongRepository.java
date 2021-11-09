package Ptit.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.Phong;
@Repository
public interface PhongRepository extends JpaRepository<Phong, Integer>{

}
