package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Request testFindAll() {
        List<Cache> caches;
        LocalDateTime launch;
        LocalDateTime end;

        launch = LocalDateTime.now();
        caches = cacheRepository.findAll();
        end = LocalDateTime.now();

        return Request.builder()
                .launchTime(launch)
                .result(caches)
                .endTime(end)
                .build();
    }

    @Override
    public Request testAddCaches(int number) {

        LocalDateTime launch;
        LocalDateTime end;
        List<String> messages = new ArrayList<>();

        List<Cache> caches = Stream.generate(() -> Cache.builder()
                .id(UUID.randomUUID().toString())
                .lieu("Lens, rue Jean Souvraz")
                .latitude(50.43498770435874f)
                .longitude(2.8234892199924206f)
                .proprietaire(Utilisateur.builder()
                        .id(UUID.randomUUID().toString())
                        .description("Awesome piss of code")
                        .pseudo("Francis")
                        .photo("*grimace*")
                        .build())
                .build())
                .limit(number)
                .collect(Collectors.toList());

        launch = LocalDateTime.now();
        cacheRepository.saveAll(caches);
        end = LocalDateTime.now();

        messages.add(number + " Cache(s) succefully created.");
        messages.add(caches.stream().map(Cache::getId).collect(Collectors.joining("-", "{", "}")));

        return Request.builder()
                .launchTime(launch)
                .result(messages)
                .endTime(end)
                .build();
    }
}
