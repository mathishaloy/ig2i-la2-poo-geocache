package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CacheRepositoryImpl implements CacheRepository {

    private final CacheJpaRepository cacheJpaRepository;

    @Override
    public Cache findCacheById(String id) {

        return Optional.ofNullable(cacheJpaRepository.getCacheEntityById(id))
                .map(CacheEntityMapper::toDomain)
                .orElse(null);

    }

    @Override
    public void saveAll(List<Cache> caches) {
        cacheJpaRepository.saveAll(caches.stream().map(CacheEntityMapper::toEntity).collect(Collectors.toList()));
    }

    @Override
    public List<Cache> findAll() {
        return cacheJpaRepository.findAll().stream().map(CacheEntityMapper::toDomain).collect(Collectors.toList());
    }


}
