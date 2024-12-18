package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class playerService {
    //contains the business logic and seeds between the controller and the repository which interact with the database

    private final playerRepository playerRepository;//create a feild to store our repository

    @Autowired
    public playerService(playerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //methods that actually acts like the business logic
    public List<playerEntity> getPlayers() {
        //get a list of players
        return playerRepository.findAll();
    }

    public List<playerEntity> getPlayersFromTeam(String teamName) {
        //get a list of players from a specific team
        return playerRepository.findAll().stream()
                .filter(playerEntity -> teamName.equals(playerEntity.getTeamName()))
                .collect(Collectors.toList());
    }

    public List<playerEntity> getPlayersByName(String searchText) {
        //get a list of players from a specific name
        return playerRepository.findAll().stream()
                .filter(playerEntity -> playerEntity.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<playerEntity> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(playerEntity ->
                        playerEntity.getPosition().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<playerEntity> getPlayersByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(playerEntity -> playerEntity.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<playerEntity> getPlayersByTeamAndPosition(String team,String position) {
        return playerRepository.findAll().stream()
                .filter(playerEntity -> team.equals(playerEntity.getTeamName()) && position.equals(playerEntity.getPosition()))
                .collect(Collectors.toList());
    }

    public playerEntity addPlayer(playerEntity addedPlayer) {
        playerRepository.save(addedPlayer);
        return addedPlayer;
    }

    public playerEntity updatePlayer(playerEntity updatedPlayer) {
        Optional<playerEntity> existingPLayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPLayer.isPresent()){
            playerEntity playerToUpdate = existingPLayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeamName(updatedPlayer.getTeamName());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setNation(updatedPlayer.getNation());

            playerRepository.save(playerToUpdate);
            return updatedPlayer;
        }
        return null;
    }

    @Transactional
    public void deletePlayerByName(String playerName) {
        playerRepository.deleteByName(playerName);

    }

}