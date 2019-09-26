package com.sample.addapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sample.addapi.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

	@Query(nativeQuery = true, value = "SELECT * FROM Player where PLAYER_NAME =:playerName")
	public List<Player> findByPlayerName(@Param("playerName") String playerName);

	@Query(nativeQuery = true, value = "Select * From Player where PLAYER_COUNTRY =:playerCountry")
	public List<Player> findByPlayerCountry(@Param("playerCountry") String playerCountry);

	public List<Player> findByPlayerId(String playerId);

	public boolean existsPlayerByPlayerUserName(String PlayerUserName);

	public boolean existsPlayerByPlayerId(String playerId);

}
