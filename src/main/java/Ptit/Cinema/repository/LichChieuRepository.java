package Ptit.Cinema.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Ptit.Cinema.model.LichChieu;

@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Integer> {

	@Query(value = "SELECT l FROM LichChieu l WHERE l.phong.ten LIKE %?1%" + "OR l.phim.ten LIKE %?1%")
	public List<LichChieu> findAll(String keyword);

	@Query(value = "SELECT * FROM LichChieu l WHERE l.phong_id =:room_id "
			+ "AND ((l.thoigianchieu <= :start AND l.thoigianketthuc >=:start) OR (l.thoigianchieu <= :end AND l.thoigianketthuc >= :end) "
			+ "OR (l.thoigianchieu > :start AND l.thoigianketthuc <:end))", nativeQuery = true)
	public Optional<List<LichChieu>> findLichChieuByRoomAndTimeStartOrTimeEnd(int room_id, Timestamp start,
			Timestamp end);
}
