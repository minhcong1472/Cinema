package Ptit.Cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ptit.Cinema.model.LichChieu;
import Ptit.Cinema.repository.LichChieuRepository;

@Service
public class LichChieuService {
	@Autowired
	LichChieuRepository lichchieuRepository;

	public List<LichChieu> getAllLichChieu(String keyword) {
		if (keyword != null) {
			return lichchieuRepository.findAll(keyword);
		}
		return lichchieuRepository.findAll();
	}

	public void LuuCapNhat(LichChieu lichchieu) {
		lichchieuRepository.save(lichchieu);
	}

	public void removeShowTimes(int id) {
		lichchieuRepository.deleteById(id);
	}

	public Optional<LichChieu> getLichChieuTheoId(int id) {
		return lichchieuRepository.findById(id);
	}

}
