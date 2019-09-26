package com.sample.addapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.addapi.model.Player;
import com.sample.addapi.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerrepository;

	@Override
	public Player addPlayer(Player player) {

		return playerrepository.save(player);
	}

	@Override
	public List<Player> getAllPlayers() {

		List<Player> list = new ArrayList<Player>();
		list = playerrepository.findAll();
		return list;
	}

	@Override
	public Optional<Player> getById(int playerId) {

		String value = String.valueOf(playerId);
		Optional<Player> list = playerrepository.findById(value);

		return list;
	}

	@Override
	public List<Player> getPlayerByName(String playerName) {
		List<Player> value = playerrepository.findByPlayerName(playerName);

		return value;
	}

	@Override
	public Player updatePlayer(Player player, int PlayerId) throws Exception {
		String val = String.valueOf(PlayerId);
		Optional<Player> findById = playerrepository.findById(val);

		if (findById == null) {
			throw new Exception("Player Not found with id" + " " + PlayerId);
		}

		Player playernew = findById.get();
		playernew.setPlayerName(player.getPlayerName());
		playernew.setPlayerAge(player.getPlayerAge());
		playernew.setPlayerGender(player.getPlayerGender());
		playernew.setPlayerCountry(player.getPlayerCountry());
		return playerrepository.save(playernew);

	}

	@Override
	public String deleteById(int playerId) {
		String value = String.valueOf(playerId);

		playerrepository.deleteById(value);
		int result = Integer.parseInt(value);
		return "Successfully deleted player with id" + result;
	}

	@Override
	public String deleteAllPlayer() {

		playerrepository.deleteAll();

		return "Delete Success";

	}

	@Override
	public List<Player> getPlayerByCountry(String playerCountry) {
		List<Player> list = playerrepository.findByPlayerCountry(playerCountry);

		return list;
	}

	@Override
	public boolean updateRestrictions(Player player, int playerId) {

		List<Player> input = playerrepository.findByPlayerId(String.valueOf(playerId));

		if (input.get(0).getPlayerUserName().equals(player.getPlayerUserName())) {

			return true;
		}
		return false;

	}

}
