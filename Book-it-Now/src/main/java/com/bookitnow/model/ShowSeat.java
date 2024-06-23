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
@Table(name = "show_seat_details")
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private double seatPrice;
    private Boolean isSeatAvailable;

    @ManyToOne
    @JoinColumn
    private Show show;
}
