package Ptit.Cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.LichChieu;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer> {

	@Query(value = "SELECT l FROM LichChieu l WHERE l.phong.ten LIKE %?1%"
			+ "OR l.phim.ten LIKE %?1%")
	public List<LichChieu> findAll(String keyword);
//	@Query(value = "SELECT l FROM LichChieu l WHERE l.giave = ?1")
//	public List<LichChieu> findAllLC(Double key);
}
