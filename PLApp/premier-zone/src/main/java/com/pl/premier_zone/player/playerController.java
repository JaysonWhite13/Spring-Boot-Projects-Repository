package com.pl.premier_zone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class playerController {

    private final playerService playerService;

    @Autowired
    public playerController(playerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<playerEntity> getPlayers(
            @RequestParam(required = false)String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation
    ) {
        if (team != null && position != null) {
            return playerService.getPlayersByTeamAndPosition(team, position);
        }else if (team != null){
            return playerService.getPlayersFromTeam(team);
        }else if (name != null){
            return playerService.getPlayersByName(name);
        }else if(position != null){
            return playerService.getPlayersByPosition(position);
        } else if(nation != null) {
            return playerService.getPlayersByNation(nation);
        }else{
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<playerEntity> addPlayer(@RequestBody playerEntity playerEntity){
        playerEntity createdPlayer = playerService.addPlayer(playerEntity);
        return new ResponseEntity<>(createdPlayer , HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<playerEntity> updatePlayer(@RequestBody playerEntity updatedPlayerEntity){
        playerEntity resultPlayer = playerService.updatePlayer(updatedPlayerEntity);
        if (resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String name){
        playerService.deletePlayerByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
