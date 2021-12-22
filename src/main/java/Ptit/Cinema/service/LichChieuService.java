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
	
	public List<LichChieu> getAllShowTimes(String keyword){
		if(keyword!=null) {
			return lichchieuRepository.findAll(keyword);
	}
		return lichchieuRepository.findAll();
	}
//	public List<LichChieu> getAllLichChieuLC(Double key) {
//		if (key != null) {
//			return lichchieuRepository.findAllLC(key);
//		}
//		return lichchieuRepository.findAll();
//	}
	
	public void saveShowTimes(LichChieu lichchieu) {
		lichchieuRepository.save(lichchieu);
	}
	
	public void removeShowTimes(int id) {
		lichchieuRepository.deleteById(id);
	}
	public Optional<LichChieu> getShowTimesById(int id){
		return lichchieuRepository.findById(id);
	}

	
}
