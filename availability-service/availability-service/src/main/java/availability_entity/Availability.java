package availability_entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    private Long trainId;
    private String travelDate; // Format: YYYY-MM-DD
    private String classType; // Example: Sleeper, AC1, AC2, etc.
    private int totalSeats;
    private int availableSeats;
}
