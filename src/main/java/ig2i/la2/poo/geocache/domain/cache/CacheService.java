package ig2i.la2.poo.geocache.domain.cache;

import ig2i.la2.poo.geocache.domain.Request;

public interface CacheService {

    Cache findCacheById(String id);

    Request testFindCacheById(String id);

}
