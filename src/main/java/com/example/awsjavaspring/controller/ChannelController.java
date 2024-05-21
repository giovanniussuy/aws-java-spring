package com.example.awsjavaspring.controller;

import com.example.awsjavaspring.model.Channel;
import com.example.awsjavaspring.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController {

    @Autowired
    ChannelService service;

    @PostMapping("/channel")
    public Channel insertChannel(@RequestBody Channel channel) {
        return service.insertChannel(channel);
    }

    @GetMapping("/channels")
    public Page<Channel> findAllChannelsPageable(@PageableDefault(sort = "id") Pageable page) {
        return service.findAllChannelsPageable(page);
    }
}
