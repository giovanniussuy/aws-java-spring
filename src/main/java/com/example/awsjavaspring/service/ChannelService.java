package com.example.awsjavaspring.service;

import com.example.awsjavaspring.model.Channel;
import com.example.awsjavaspring.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository repository;

    public Page<Channel> findAllChannelsPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Channel insertChannel(Channel channel) {
        channel.setLastUpadate(LocalDateTime.now());
        return repository.save(channel);
    }
}
