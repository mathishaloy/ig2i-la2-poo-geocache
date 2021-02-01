package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CacheRepositoryImpl implements CacheRepository {

    private final CacheJpaRepository cacheJpaRepository;

    @Override
    public Cache findGeocache(String id) {

        return Optional.ofNullable(cacheJpaRepository.getCacheEntityById(id))
                .map(CacheEntityMapper::toDomain)
                .orElse(null);

    }
}
