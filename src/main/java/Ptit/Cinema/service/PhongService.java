package Ptit.Cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ptit.Cinema.model.Phong;
import Ptit.Cinema.repository.PhongRepository;

@Service
public class PhongService {

	@Autowired
	PhongRepository phongRepository;
	
	public List<Phong> getAllRoom(){
		return phongRepository.findAll();
	}
	
	public void addRoom(Phong phong) {
		phongRepository.save(phong);
	}
	
	public void removeRoom(int id) {
		phongRepository.deleteById(id);
	}
	public Optional<Phong> getRoomById(int id){
		return phongRepository.findById(id);
	}
}
