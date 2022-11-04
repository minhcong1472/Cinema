package Ptit.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.NhanVien;
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{
	NhanVien findByEmail(String email);
}
