package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheJpaRepository extends JpaRepository<CacheEntity, String> {

    CacheEntity getCacheEntityById(String id);

}
