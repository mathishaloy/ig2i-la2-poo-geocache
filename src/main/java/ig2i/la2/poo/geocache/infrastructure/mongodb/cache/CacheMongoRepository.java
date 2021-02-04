package ig2i.la2.poo.geocache.infrastructure.mongodb.cache;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheMongoRepository extends MongoRepository<CacheMongo, String> {
}
