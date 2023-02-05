package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
        HashMap<String,Movie> movieD = new HashMap<>();
        HashMap<String,Director> directorD = new HashMap<>();
        HashMap<String,List<String>>MDpair = new HashMap<>();
        
        public String addMovie(Movie movie) {
        	String name = movie.getName();
        	movieD.put(name, movie);
        	return "Movie added successfully";
        }
        
        public String addDirector(Director director) {
        	String name = director.getName();
        	directorD.put(name, director);
        	return "Director added successfully";
        }
        
        public String addMovieDiretorPair(String nameM,String nameD) {
        	if(!movieD.containsKey(nameM) || !directorD.containsKey(nameD)) {
        		return "Movie or Director not found in database";
        	}
        	List<String>m1 = MDpair.getOrDefault(nameD, new ArrayList<>());
        	if(m1.contains(nameM)) {
        		return "Pair already exist";
        	}
        	m1.add(nameM);
        	MDpair.put(nameM, m1);
        	return "Paid added successfully";
        }
        
        public Movie getMovieByName(String nameM) {
        	if(movieD.containsKey(nameM)) {
        		return movieD.get(nameM);
        	}
        	return null;
        }
        
        public Director getDirectorByName(String nameD) {
        	if(directorD.containsKey(nameD)) {
        		return directorD.get(nameD);
        	}
        	return null;
        }
        public List<String>getMoviesByDirectorName(String nameD){
        	if(MDpair.containsKey(nameD)) {
        		return MDpair.get(nameD);
        	}
        	return null;
        }
        public List<String> findAllMovies(){
        	List<String>allmovie=new ArrayList<>();
        	for(String m:movieD.keySet()) {
        		allmovie.add(m);
        	}
        	return allmovie;
        }
        public String deleteDirectorByName(String nameD) {
        	List<String>m1 = new ArrayList<>();
        	if(MDpair.containsKey(nameD)) {
        		m1=MDpair.get(nameD);
        	}
        	for(String movie:m1) {
        		if(movieD.containsKey(movie)) {
        			movieD.remove(movie);
        		}
        	}
        	MDpair.remove(nameD);
        	if(directorD.containsKey(nameD)) {
        		directorD.remove(nameD);
        	}
        	return "Director and its movies removed successfully";
        }
        public String deleteAllDirectors() {
        	for(String d:MDpair.keySet()) {
        		List<String>dm1 = new ArrayList<>();
        		dm1=MDpair.get(d);
        		for(String movie:dm1) {
        			if(MDpair.containsKey(movie)) {
        				MDpair.remove(movie);
        			}
        		}
        		MDpair.remove(d);
        	}
        	for(String d:directorD.keySet()) {
        		directorD.remove(d);
        	}
        	return "All directors and their movies removed successfully";
        }
}
