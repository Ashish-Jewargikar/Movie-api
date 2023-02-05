package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public String addMovie(Movie movie) {
		return movieRepository.addMovie(movie);
	}
	
	public String addDirector(Director director) {
		return movieRepository.addDirector(director);
	}
	
	public String addMovieDirectorPair(String nameM,String nameD) {
		return movieRepository.addMovieDiretorPair(nameM, nameD);
	}
	
	public Movie getMovieByName(String nameM) {
		return movieRepository.getMovieByName(nameM);
	}
	
	public Director getDirectorByName(String nameD) {
		return movieRepository.getDirectorByName(nameD);
	}
	
	public List<String> getMoviesByDirectorName(String nameD){
		return movieRepository.getMoviesByDirectorName(nameD);
	}
	
	public List<String> findAllMovies(){
		return movieRepository.findAllMovies();
	}
	public String deleteDirectorByName(String nameD) {
		return movieRepository.deleteDirectorByName(nameD);
	}
	public String deleteAllDirectors() {
		return movieRepository.deleteAllDirectors();
	}
}
