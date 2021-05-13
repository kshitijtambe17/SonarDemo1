package com.infosys.games.dao;
import org.springframework.data.repository.CrudRepository;

import com.infosys.games.entity.Games;

public interface GamesRepository extends CrudRepository<Games,String> {

	
}
