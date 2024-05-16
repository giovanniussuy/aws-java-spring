package com.example.awsjavaspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbsigla_channels")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cnl", nullable = false)
    private Long id;
    @Column(name = "cod_cnl", nullable = false)
    private String code;
    @Column(name = "nam_cnl", nullable = false)
    private String name;
    @Column(name = "cnl_atv", nullable = false)
    private boolean active;
    @Column(name = "usr_id", nullable = false)
    private String userId;
    @Column(name = "dt_lst_upd", nullable = false)
    private LocalDateTime lastUpadate;

    @Deprecated
    public Channel() {
    }

    public Channel(Long id, String code, String name, boolean active, String userId, LocalDateTime lastUpadate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active;
        this.userId = userId;
        this.lastUpadate = lastUpadate;
    }

    @Override
    public String toString() {
        return "Channels{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", userId='" + userId + '\'' +
                ", lastUpadate=" + lastUpadate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getLastUpadate() {
        return lastUpadate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastUpadate(LocalDateTime lastUpadate) {
        this.lastUpadate = lastUpadate;
    }
}
