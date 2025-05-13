package fare_entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fareId;

    private Long trainId;
    private String classType; // Example: Sleeper, AC, General
    private Double amount;
}
