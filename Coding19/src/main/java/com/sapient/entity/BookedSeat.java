package com.sapient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BookedSeat")
@EntityListeners(AuditingEntityListener.class)
@Data
public class BookedSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_booked_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonIgnore
    private Show show;
}
