package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurMapper;

public abstract class CacheEntityMapper {

    public static Cache toDomain(CacheEntity entity){
        return Cache.builder()
                .id(entity.getId())
                .proprietaire(UtilisateurMapper.toDomain(entity.getProprietaire()))
                .etat(entity.getEtat())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .lieu(entity.getLieu())
                .nature(entity.getNature())
                .type(entity.getType())
                .build();
    }

    public static CacheEntity toEntity(Cache cache){
        return CacheEntity.builder()
                .id(cache.getId())
                .build();
    }
}
