package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TICKETS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Integer totalTicketsPrice;
    private String bookedSeats;

    @CreationTimestamp
    private LocalDateTime bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;

}
