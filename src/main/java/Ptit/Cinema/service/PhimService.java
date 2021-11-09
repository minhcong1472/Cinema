package Ptit.Cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ptit.Cinema.model.Phim;
import Ptit.Cinema.repository.PhimRepository;

@Service
public class PhimService {

	@Autowired
	PhimRepository phimRepository;
	
	public List<Phim> getAllMovie(){
		return phimRepository.findAll();
	}
	
	public void addMovie(Phim phim) {
		phimRepository.save(phim);
	}
	
	public void removeMovie(int id) {
		phimRepository.deleteById(id);
	}
	public Optional<Phim> getMovieById(int id){
		return phimRepository.findById(id);
	}
}
