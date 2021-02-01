package ig2i.la2.poo.geocache.infrastructure.mysql.visite;

import ig2i.la2.poo.geocache.domain.visite.Visite;
import ig2i.la2.poo.geocache.infrastructure.mysql.cache.CacheEntityMapper;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurEntity;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurMapper;

public abstract class VisiteMapper {
    public static Visite toDomain(VisiteEntity entity){
        return Visite.builder()
                .id(entity.getId())
                .cache(CacheEntityMapper.toDomain(entity.getCache()))
                .utilisateur(UtilisateurMapper.toDomain(entity.getUtilisateur()))
                .commentaire(entity.getCommentaire())
                .photo(entity.getPhoto())
                .build();
    }
}
