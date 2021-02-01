package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurMapper;

import java.util.Optional;

public abstract class CacheEntityMapper {

    public static Cache toDomain(CacheEntity entity) {
        return Cache.builder()
                .id(entity.getId())
                .etat(entity.getEtat())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .lieu(entity.getLieu())
                .nature(entity.getNature())
                .type(entity.getType())
                .proprietaire(Optional.ofNullable(entity.getProprietaire())
                        .map(UtilisateurMapper::toDomain)
                        .orElse(null))
                .build();
    }

    public static CacheEntity toEntity(Cache cache) {
        return CacheEntity.builder()
                .id(cache.getId())
                .etat(cache.getEtat())
                .latitude(cache.getLatitude())
                .longitude(cache.getLongitude())
                .lieu(cache.getLieu())
                .nature(cache.getNature())
                .type(cache.getType())
                .proprietaire(Optional.ofNullable(cache.getProprietaire())
                        .map(UtilisateurMapper::toEntity)
                        .orElse(null))
                .build();
    }
}
