package be.pxl.demo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<CounterStrikeWeapons, Long> {
}
