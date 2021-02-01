package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;

public abstract class UtilisateurMapper {
    public static Utilisateur toDomain(UtilisateurEntity entity){
        return Utilisateur.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .pseudo(entity.getPseudo())
                .photo(entity.getPhoto())
                .build();
    }
}
