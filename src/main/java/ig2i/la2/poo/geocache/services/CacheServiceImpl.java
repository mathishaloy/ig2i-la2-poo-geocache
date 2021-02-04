package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;

    @Override
    public Cache findCacheById(String id) {
        return Optional.ofNullable(cacheRepository.findCacheById(id))
                .orElseThrow(() -> new RuntimeException("Geocache " + id + " cannot be found"));
    }

    @Override
    public Request testFindCacheById(String id) {

        List<Cache> caches = new ArrayList<>();
        LocalDateTime launch;
        LocalDateTime end;

        launch = LocalDateTime.now();
        caches.add(cacheRepository.findCacheById(id));
        end = LocalDateTime.now();

        return Request.builder()
                .launchTime(launch)
                .result(caches)
                .endTime(end)
                .build();
    }
}
