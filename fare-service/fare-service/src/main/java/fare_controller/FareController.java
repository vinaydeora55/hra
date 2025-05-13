package fare_controller;



import fare_entity.Fare;
import fare_service.FareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fares")
@RequiredArgsConstructor
public class FareController {

    private final FareService fareService;

    @PostMapping
    public ResponseEntity<Fare> createFare(@RequestBody Fare fare) {
        return ResponseEntity.ok(fareService.createFare(fare));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fare> getFare(@PathVariable Long id) {
        return fareService.getFareById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Fare>> getAllFares() {
        return ResponseEntity.ok(fareService.getAllFares());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fare> updateFare(@PathVariable Long id, @RequestBody Fare fare) {
        return ResponseEntity.ok(fareService.updateFare(id, fare));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFare(@PathVariable Long id) {
        fareService.deleteFare(id);
        return ResponseEntity.noContent().build();
    }
}
