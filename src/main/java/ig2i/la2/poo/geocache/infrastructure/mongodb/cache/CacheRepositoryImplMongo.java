package ig2i.la2.poo.geocache.infrastructure.mongodb.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mongodb")
public class CacheRepositoryImplMongo implements CacheRepository {
    @Override
    public Cache findCacheById(String id) {
        return null;
    }

    @Override
    public void saveAll(List<Cache> caches) {

    }

    @Override
    public List<Cache> findAll() {
        return null;
    }
}
