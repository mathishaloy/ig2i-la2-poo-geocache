package ig2i.la2.poo.geocache.infrastructure.mongodb.utilisateur;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurEntity;

public abstract class UtilisateurMongoMapper {
    public static Utilisateur toDomain(UtilisateurMongo mongo){
        return Utilisateur.builder()
                .description(mongo.getDescription())
                .pseudo(mongo.getPseudo())
                .photo(mongo.getPhoto())
                .build();
    }

    public static UtilisateurMongo toMongo(Utilisateur utilisateur){
        return UtilisateurMongo.builder()
                .description(utilisateur.getDescription())
                .pseudo(utilisateur.getPseudo())
                .photo(utilisateur.getPhoto())
                .build();
    }
}
