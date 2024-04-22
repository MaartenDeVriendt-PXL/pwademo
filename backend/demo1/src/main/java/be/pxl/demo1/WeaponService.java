package be.pxl.demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public CounterStrikeWeapons addCounterStrikeWeapons(WeaponRequest weaponRequest) {
        CounterStrikeWeapons counterStrikeWeapons = new CounterStrikeWeapons();
        counterStrikeWeapons.setName(weaponRequest.name());
        counterStrikeWeapons.setType(weaponRequest.type());
        counterStrikeWeapons.setImageUrl(weaponRequest.imageUrl());
        weaponRepository.save(counterStrikeWeapons);
        return counterStrikeWeapons;
    }

    public List<CounterStrikeWeapons> getAllWeapons() {
        return weaponRepository.findAll();
    }

    public List<CounterStrikeWeapons> getAllAssaultRifles() {
        List<CounterStrikeWeapons> allWeapons = weaponRepository.findAll();
        return allWeapons.stream()
                .filter(weapon -> "assault".equals(weapon.getType()))
                .collect(Collectors.toList());
    }




}
