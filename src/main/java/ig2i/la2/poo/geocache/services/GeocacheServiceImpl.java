package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.Geocache;
import ig2i.la2.poo.geocache.domain.GeocacheRepository;
import ig2i.la2.poo.geocache.domain.GeocacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeocacheServiceImpl implements GeocacheService {

    private final GeocacheRepository geocacheRepository;

    @Override
    public Geocache findGeocache(String id) {
        System.out.println(LocalDateTime.now());
        return Optional.ofNullable(geocacheRepository.findGeocache(id))
                .orElseThrow(() -> new RuntimeException("Geocache " + id + " cannot be found"));
    }
}
