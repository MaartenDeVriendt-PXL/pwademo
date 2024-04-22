package be.pxl.demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counter-strike")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class WeaponController {
    private final WeaponService weaponService;

    @PostMapping("/add-weapon")
    public CounterStrikeWeapons addCounterStrikeWeapon(@RequestBody WeaponRequest weaponRequest) {
        return weaponService.addCounterStrikeWeapons(weaponRequest);
    }

    @GetMapping("/weapons")
    public List<CounterStrikeWeapons> getAllWeapons() {
        return weaponService.getAllWeapons();
    }

    @GetMapping("/assault-rifles")
    public List<CounterStrikeWeapons> getAllAssaultRifles() {
        return weaponService.getAllAssaultRifles();
    }
}
