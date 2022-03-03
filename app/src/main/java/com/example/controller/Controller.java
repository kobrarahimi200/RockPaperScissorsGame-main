package com.example.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.logic.Game;
import com.example.logic.Winner;
 
@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class Controller {
	
	public Game game = new Game();
	
	@GetMapping("/{choiceName}")
	public Winner doPlay(@PathVariable String choiceName) {
		game.doPlay(choiceName);
		return game.getResult();
	}

	@GetMapping("/reset")
	public void reset(){
		System.out.println("reset in conroller");
		game.reset();
	}
}
