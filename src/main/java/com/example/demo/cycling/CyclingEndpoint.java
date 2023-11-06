package com.example.demo.cycling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cycling")
public class CyclingEndpoint {

    @Autowired
    RiderRepo riderRepo;

    @Autowired
    TeamRepo teamRepo;

    @PostMapping("/rider")
    public Rider createRider(@RequestBody Rider rider) {


        System.out.println("Rider: " + rider);
        return riderRepo.save(rider);
    }

    @GetMapping("/rider")
    public List<Rider> list() {
        return riderRepo.findAll();
    }

    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {


        System.out.println("Team: " + team);
        return teamRepo.save(team);
    }

    @GetMapping("/team")
    public List<Team> listTeam() {
        return teamRepo.findAll();
    }


}
