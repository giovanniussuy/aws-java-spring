package com.example.awsjavaspring.repository;

import com.example.awsjavaspring.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
