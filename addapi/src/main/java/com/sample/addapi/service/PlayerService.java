package com.sample.addapi.service;

import java.util.List;
import java.util.Optional;

import com.sample.addapi.model.Player;

public interface PlayerService {

	public Player addPlayer(Player player);

	public List<Player> getAllPlayers();

	public Optional<Player> getById(int playerId);

	public List<Player> getPlayerByName(String playerName);

	public List<Player> getPlayerByCountry(String playerCountry);

	public Player updatePlayer(Player player, int PlayerId) throws Exception;

	public String deleteById(int playerId);

	public String deleteAllPlayer();

	public boolean updateRestrictions(Player player, int playerId);

}
