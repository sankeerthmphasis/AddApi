package com.sample.addapi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sample.addapi.repository.PlayerRepository;

@Component
public class CrudValidation {

	@Autowired
	private PlayerRepository playerRepository;

	public boolean isIdValid(String playerId) {

		if (!Pattern.matches("^[0-9]+$", playerId)) {
			return false;
		}
		return true;
	}

	public boolean isNameValid(String playerName) {

		if (Pattern.matches("[a-z]*$", playerName)) {

			return true;

		}
		return false;
	}

	public boolean isUserNameHasAlphaNumeric(String playerUserName) {

		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(playerUserName);
		
		if (matcher.find()) {
		
			return true;
		}
		return false;
	}

	public boolean isEmpty(String grade) {
		if (StringUtils.isEmpty(grade)) {

			return false;
		}
		return true;

	}

	public boolean isPlayerUserNameExist(String playerUserName) {
		return playerRepository.existsPlayerByPlayerUserName(playerUserName);
	}

	public boolean isPlayerWithIdExists(String playerId) {
		return playerRepository.existsPlayerByPlayerId(playerId); 

	}

}