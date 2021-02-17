package ig2i.la2.poo.geocache.infrastructure.mysql.visite;

import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.infrastructure.mysql.cache.CacheEntityMapper;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurMapper;

import java.util.Optional;

public abstract class VisiteMapper {
    public static Visite toDomain(VisiteEntity entity) {
        return Visite.builder()
                .id(entity.getId())
                .cache(CacheEntityMapper.toDomain(entity.getCache()))
                .utilisateur(UtilisateurMapper.toDomain(entity.getUtilisateur()))
                .commentaire(entity.getCommentaire())
                .photo(entity.getPhoto())
                .build();
    }

    public static VisiteEntity toEntity(Visite visite) {
        return VisiteEntity.builder()
                .id(visite.getId())
                .cache(Optional.ofNullable(visite.getCache())
                        .map(CacheEntityMapper::toEntity)
                        .orElse(null))
                .utilisateur(Optional.ofNullable(visite.getUtilisateur())
                        .map(UtilisateurMapper::toEntity)
                        .orElse(null))
                .commentaire(visite.getCommentaire())
                .photo(visite.getPhoto())
                .build();
    }
}