package ig2i.la2.poo.geocache.domain.cache;

import java.util.List;

public interface CacheRepository {

    Cache findCacheById(String id);

    void saveAll(List<Cache> caches);

}
