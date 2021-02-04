package ig2i.la2.poo.geocache.infrastructure.mock.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
@Profile("mockdb")
@Slf4j
public class CacheRepositoryImplMock implements CacheRepository {

    @Override
    public Cache findCacheById(String id) {
        log.warn("/!\\ CacheRepository is mocked /!\\");
        return Cache.builder()
                .id(UUID.randomUUID().toString())
                .lieu("Lens, rue Jean Souvraz")
                .latitude(50.43498770435874f)
                .longitude(2.8234892199924206f)
                .build();

    }

    @Override
    public void saveAll(List<Cache> caches) {
        log.warn("/!\\ CacheRepository is mocked /!\\");
    }

    @Override
    public List<Cache> findAll() {
        log.warn("/!\\ CacheRepository is mocked /!\\");
        return Stream.generate(() -> Cache.builder()
                .id(UUID.randomUUID().toString())
                .lieu("Lens, rue Jean Souvraz")
                .latitude(50.43498770435874f)
                .longitude(2.8234892199924206f)
                .build())
                .limit(10)
                .collect(Collectors.toList());
    }


}
