package com.sample.addapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sample.addapi.exception.InvalidInputException;
import com.sample.addapi.model.Player;
import com.sample.addapi.service.PlayerService;
import com.sample.addapi.util.CrudValidation;

@RestController
@RequestMapping("/Player")
public class PlayerController {

	@Autowired
	private PlayerService playerservice;

	@Autowired
	CrudValidation crud;

	@PostMapping(value = "/savePlayers")
	public Player addPlayer(@RequestBody Player player) {
		Player player1 = null;

		if (!crud.isUserNameHasAlphaNumeric(player.getPlayerUserName())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"UserName must contain CharacterS and Atleast one Number ");
		}
		if (crud.isPlayerUserNameExist(player.getPlayerUserName())) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"UserName you Entered is Already Exists!! Please Enter another Username");

		} else {
			player1 = playerservice.addPlayer(player);
		}

		return player1;

	}

	@GetMapping(value = "/getAllPlayers")
	public List<Player> getAllPlayers() {
		List<Player> list = new ArrayList<Player>();
		list = playerservice.getAllPlayers();
		return list;
	}

	@GetMapping(value = "/getPlayerById/{playerId}")
	public Optional<Player> getPlayerById(@PathVariable("playerId") int playerId) {

		String value = String.valueOf(playerId);
		boolean result = crud.isIdValid(value);

		if (!result) {

			throw new InvalidInputException("Enter Valid Input");
		}

		Optional<Player> list = playerservice.getById(playerId);

		return list;

	}

	@GetMapping(value = "/getPlayersByName/{playerName}")
	public List<Player> getPlayerByName(@PathVariable("playerName") String playerName) {

		boolean result = crud.isNameValid(playerName);
		if (!result) {
			throw new InvalidInputException("Enter Alphabets");
		}

		List<Player> list = playerservice.getPlayerByName(playerName);
		return list;
	}

	@GetMapping(value = "/getPlayersByCountry/{playerCountry}")
	public List<Player> getPlayerByCountry(@PathVariable String playerCountry) {
		List<Player> list = playerservice.getPlayerByCountry(playerCountry);

		return list;
	}

	@DeleteMapping(value = "/deleteAllPlayers")
	public String deleteAllPlayers() {
		String value = playerservice.deleteAllPlayer();
		return value;

	}

	@DeleteMapping(value = "/deleteById/{playerId}")
	public String deleteById(@PathVariable("playerId") int playerId) {

		if (!crud.isPlayerWithIdExists(String.valueOf(playerId))) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Player With id" + " " + playerId + " " + "not Exixts");
		}

		String value = playerservice.deleteById(playerId);
		return value;
	}

	@PutMapping(value = "/updateById/{playerId}")
	public Player updateDetails(@RequestBody Player player, @PathVariable("playerId") int playerId) throws Exception {

		if (!playerservice.updateRestrictions(player, playerId)) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"UserName Entered is not found with the playerId" + playerId);
		}
		return playerservice.updatePlayer(player, playerId);
	}

}
