package com.infosys.games.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.games.entity.Games;
import com.infosys.games.service.GamesService;

@RestController
public class GamesController {
	
	@Autowired
	private GamesService gamesService; 
	
	@RequestMapping("/games")
	public ResponseEntity<Iterable<Games>> getAllGames() throws Exception {
		Iterable<Games> games= gamesService.getGames();
		ResponseEntity<Iterable<Games>> response = new ResponseEntity<Iterable<Games>>(games, HttpStatus.OK);
		return response;				
	}

	@RequestMapping("/games/{id}")
	public ResponseEntity<Games> getOneGame(@PathVariable String id) throws Exception {
		Games game=gamesService.getOneGame(id);
		ResponseEntity<Games> response = new ResponseEntity<Games>(game, HttpStatus.OK);
		return response;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/games")
	public ResponseEntity<String> addGame(@RequestBody Games game) throws Exception {
		gamesService.addGame(game);
		String successMessage = "Game added successfully with ID:"+game.getId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/games/{id}" )
	public ResponseEntity<String> updateGame(@RequestBody Games game,@PathVariable String id) throws Exception {
		Games games=gamesService.updateGame(game, id);
		String successMessage = "Game updated successfully with ID:"+games.getId();
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/games/{id}")
	public ResponseEntity<String> deleteGame(@PathVariable String id) throws Exception {
		gamesService.deleteGame(id);
		String successMessage = "Game deleted succssfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
	}
	

	
	
	
	
	
	
	
	
}
