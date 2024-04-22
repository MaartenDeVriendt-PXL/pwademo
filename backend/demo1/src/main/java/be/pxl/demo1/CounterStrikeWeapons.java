package be.pxl.demo1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weapons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CounterStrikeWeapons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private String imageUrl;

}
