package cancellation_controller;


import cancellation_entity.Cancellation;
import cancellation_service.CancellationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancellations")
@RequiredArgsConstructor
public class CancellationController {

    private final CancellationService cancellationService;

    @PostMapping
    public ResponseEntity<Cancellation> createCancellation(@RequestBody Cancellation cancellation) {
        return ResponseEntity.ok(cancellationService.createCancellation(cancellation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancellation> getCancellation(@PathVariable Long id) {
        return cancellationService.getCancellationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cancellation>> getAllCancellations() {
        return ResponseEntity.ok(cancellationService.getAllCancellations());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancellation(@PathVariable Long id) {
        cancellationService.deleteCancellation(id);
        return ResponseEntity.noContent().build();
    }
}
