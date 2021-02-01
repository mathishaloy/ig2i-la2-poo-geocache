package ig2i.la2.poo.geocache.infrastructure.mysql;

import ig2i.la2.poo.geocache.domain.Geocache;

public abstract class GeocacheEntityMapper {

    public static Geocache toDomain(CacheEntity entity){
        return Geocache.builder()
                .id(entity.getId())
                .build();
    }

    public static CacheEntity toEntity(Geocache geocache){
        return CacheEntity.builder()
                .id(geocache.getId())
                .build();
    }

}
