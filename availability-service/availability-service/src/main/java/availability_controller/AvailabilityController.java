package availability_controller;



import availability_entity.Availability;
import availability_service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
@RequiredArgsConstructor
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        return ResponseEntity.ok(availabilityService.saveAvailability(availability));
    }

    @GetMapping
    public ResponseEntity<Availability> checkAvailability(
            @RequestParam Long trainId,
            @RequestParam String travelDate,
            @RequestParam String classType) {
        return availabilityService.getAvailability(trainId, travelDate, classType)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Availability>> getAllAvailability() {
        return ResponseEntity.ok(availabilityService.getAllAvailability());
    }

    @PutMapping("/{id}/update-seats")
    public ResponseEntity<Void> updateSeats(@PathVariable Long id, @RequestParam int seats) {
        availabilityService.updateAvailableSeats(id, seats);
        return ResponseEntity.noContent().build();
    }
}
