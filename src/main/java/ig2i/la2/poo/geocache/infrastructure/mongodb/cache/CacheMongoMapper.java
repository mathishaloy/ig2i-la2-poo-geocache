package ig2i.la2.poo.geocache.infrastructure.mongodb.cache;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.infrastructure.mongodb.utilisateur.UtilisateurMongoMapper;

import java.util.Optional;

public abstract class CacheMongoMapper {

    public static Cache toDomain(CacheMongo mongo) {
        return Cache.builder()
                .id(mongo.getId())
                .etat(mongo.getEtat())
                .latitude(mongo.getLatitude())
                .longitude(mongo.getLongitude())
                .lieu(mongo.getLieu())
                .nature(mongo.getNature())
                .type(mongo.getType())
                .proprietaire(Optional.ofNullable(mongo.getProprietaire())
                        .map(UtilisateurMongoMapper::toDomain).orElse(null))
                .build();
    }

    public static CacheMongo toMongo(Cache cache) {
        return CacheMongo.builder()
                .id(cache.getId())
                .etat(cache.getEtat())
                .latitude(cache.getLatitude())
                .longitude(cache.getLongitude())
                .lieu(cache.getLieu())
                .nature(cache.getNature())
                .type(cache.getType())
                .proprietaire(Optional.ofNullable(cache.getProprietaire())
                    .map(UtilisateurMongoMapper::toMongo).orElse(null))
                .build();
    }
}