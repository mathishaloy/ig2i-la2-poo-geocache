package ig2i.la2.poo.geocache.infrastructure.mongodb.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Profile("mongodb")
public class CacheRepositoryImplMongo implements CacheRepository {

    private final CacheMongoRepository cacheMongoRepository;


    @Override
    public Cache findCacheById(String id) {
        return cacheMongoRepository.findById(id)
                .map(CacheMongoMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void saveAll(List<Cache> caches) {
        cacheMongoRepository.saveAll(caches.stream().map(CacheMongoMapper::toMongo).collect(Collectors.toList()));
    }

    @Override
    public List<Cache> findAll() {
        return cacheMongoRepository.findAll().stream().map(CacheMongoMapper::toDomain).collect(Collectors.toList());
    }
}
