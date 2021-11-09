package Ptit.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.Rap;
@Repository
public interface RapRepository extends JpaRepository<Rap, Integer>{

}
