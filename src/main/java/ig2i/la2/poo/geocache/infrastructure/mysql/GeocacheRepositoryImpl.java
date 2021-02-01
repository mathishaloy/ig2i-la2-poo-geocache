package ig2i.la2.poo.geocache.infrastructure.mysql;

import ig2i.la2.poo.geocache.domain.Geocache;
import ig2i.la2.poo.geocache.domain.GeocacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GeocacheRepositoryImpl implements GeocacheRepository {

    private final CacheJpaRepository cacheJpaRepository;

    @Override
    public Geocache findGeocache(String id) {

        return Optional.ofNullable(cacheJpaRepository.getCacheEntityById(id))
                .map(GeocacheEntityMapper::toDomain)
                .orElse(null);

    }
}
