package ig2i.la2.poo.geocache.infrastructure.mappers;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.infrastructure.mysql.CacheEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CacheMapper {

    @Mappings({
            @Mapping(target = "id", source = "id_cache")
    })
    Cache SqlEntityToDomain(CacheEntity cacheEntity);


    @Mappings({
            @Mapping(target = "id_cache", source = "id")
    })
    CacheEntity DomainToSqlEntity(Cache cache);

}
