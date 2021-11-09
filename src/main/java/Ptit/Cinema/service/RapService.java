package Ptit.Cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ptit.Cinema.model.Rap;
import Ptit.Cinema.repository.RapRepository;

@Service
public class RapService {
	@Autowired
	RapRepository rapRepository;
	
	public List<Rap> getAllCinema(){
		return rapRepository.findAll();
	}
	
	public void addCinema(Rap rap) {
		rapRepository.save(rap);
	}
	
	public void removeCineme(int id) {
		rapRepository.deleteById(id);
	}

	public Optional<Rap> getCinemaById(int id){
		return rapRepository.findById(id);
	}
}
