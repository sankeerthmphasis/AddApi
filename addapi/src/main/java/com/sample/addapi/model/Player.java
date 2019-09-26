package com.sample.addapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private String playerId;
	@Column(unique = true , name = "PlayerUserName")
	private String playerUserName;
	@Column(name = "PlayerName")
	private String playerName;
	@Column(name = "PlayerAge")
	private int PlayerAge;
	@Column(name = "PlayerGender")
	private String playerGender;
	@Column(name = "PlayerCountry")
	private String playerCountry;

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerUserName() {
		return playerUserName;
	}

	public void setPlayerUserName(String playerUserName) {
		this.playerUserName = playerUserName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerAge() {
		return PlayerAge;
	}

	public void setPlayerAge(int playerAge) {
		PlayerAge = playerAge;
	}

	public String getPlayerGender() {
		return playerGender;
	}

	public void setPlayerGender(String playerGender) {
		this.playerGender = playerGender;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

}
