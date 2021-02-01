package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;

    @Override
    public Cache findGeocache(String id) {
        return Optional.ofNullable(cacheRepository.findGeocache(id))
                .orElseThrow(() -> new RuntimeException("Geocache " + id + " cannot be found"));
    }
}
