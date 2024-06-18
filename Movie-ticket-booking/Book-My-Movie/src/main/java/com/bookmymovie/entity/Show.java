package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOWS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private String time;
    private LocalDate  date;
    @ManyToOne
    @JoinColumn
    private Movie movie;
    @ManyToOne
    @JoinColumn
    private Theater theater;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
