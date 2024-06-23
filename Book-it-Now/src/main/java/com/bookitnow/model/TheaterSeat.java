package com.bookitnow.model;

import com.bookitnow.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "theater_seat_details")
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;
    private String theaterSeatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType theaterSeatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
