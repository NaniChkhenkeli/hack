package com.kiu.hackaton.hackathon_back.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kiu.hackaton.hackathon_back.dto.request.HackathonRequest;
import com.kiu.hackaton.hackathon_back.dto.response.HackathonResponse;
import com.kiu.hackaton.hackathon_back.service.HackathonService;


@RestController
@RequestMapping("/api/hackathons")
public class HackathonController {

    private final HackathonService hackathonService;

    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HackathonResponse createHackathon(@RequestBody HackathonRequest hackathonRequest) {
        return hackathonService.createHackathon(hackathonRequest);
    }

    @GetMapping("/{hackathonId}")
    public HackathonResponse getHackathonDetails(@PathVariable Long hackathonId) {
        return hackathonService.getHackathonDetails(hackathonId);
    }
}
