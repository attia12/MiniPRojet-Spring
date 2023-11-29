package tn.esprit.twin1.EducationSpringApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.twin1.EducationSpringApp.entities.Reservation;
import tn.esprit.twin1.EducationSpringApp.services.ReservationService;

import java.util.List;

@RequestMapping("/reservation")
@RequiredArgsConstructor
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/getAll")
    public List<Reservation> getAllReservation() {
        return reservationService.findAllReservation();

    }

    @PostMapping("/new")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/update/{idReservation}")
    public Reservation updateEtudiant(@PathVariable long idReservation,@RequestBody Reservation reservation) {
        return reservationService.updateReservation(idReservation,reservation);
    }

    @GetMapping("/getId/{idReservation}")
    public Reservation getId(@PathVariable long idReservation) {
        return reservationService.findReservationById(idReservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public ResponseEntity<String> deleteReservation(@PathVariable long idReservation) {
        try {
            Reservation reservation = reservationService.findReservationById(idReservation);
            if ( reservation != null) {
                reservationService.deleteReservationById(idReservation);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other exceptions with a 500 Internal Server Error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

