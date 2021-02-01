package ig2i.la2.poo.geocache.infrastructure.mysql;

import ig2i.la2.poo.geocache.domain.cache.Cache;

public abstract class GeocacheEntityMapper {

    public static Cache toDomain(CacheEntity entity){
        return Cache.builder()
                .id(entity.getId())
                .build();
    }

    public static CacheEntity toEntity(Cache cache){
        return CacheEntity.builder()
                .id(cache.getId())
                .build();
    }

}
