package Ptit.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.Phim;
@Repository
public interface PhimRepository extends JpaRepository<Phim, Integer>{

}
