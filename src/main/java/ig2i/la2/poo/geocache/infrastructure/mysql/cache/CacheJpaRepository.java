package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Etat;
import ig2i.la2.poo.geocache.domain.cache.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CacheJpaRepository extends JpaRepository<CacheEntity, String> {

    CacheEntity getCacheEntityById(String id);

    List<CacheEntity> getCacheEntityByEtatAndNatureOrderByLatitudeDesc(Etat etat, Nature nature);

}
