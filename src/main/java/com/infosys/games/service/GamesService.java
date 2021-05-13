package com.infosys.games.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.games.dao.GamesRepository;
import com.infosys.games.entity.*;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository; 
	
	public Iterable<Games> getGames() throws Exception {
		Iterable<Games> games=gamesRepository.findAll();
		if(games.iterator().hasNext()) {
			return games;
		}
		else {
			throw new Exception("No games available!");
		}
	}

		public Games getOneGame(String id) throws Exception {
			Games games=gamesRepository.findById(id).orElse(null);
			if(games==null) {
				throw new Exception("Invalid game ID!");
			}
			return games;
		}

		public void addGame(Games game) throws Exception {
			Games games=gamesRepository.findById(game.getId()).orElse(null);
			if(games!=null){
				throw new Exception("Game already exists!");
			}
			gamesRepository.save(game);			
		}

		public Games updateGame(Games game, String id) throws Exception {
			Games existingGame=gamesRepository.findById(id).orElse(null);
			if (existingGame !=null) {
				existingGame.setName(game.getName());
				existingGame.setDescription(game.getDescription());
				return gamesRepository.save(existingGame);
			}
			else {
				throw new Exception("No game found!");
			}
			

			
		}

		public void deleteGame(String id) throws Exception {
			Games game=gamesRepository.findById(id).orElse(null);
			if(game==null) {
				throw new Exception("No games available!");
			}
			gamesRepository.deleteById(id);
			
		}
		
}
