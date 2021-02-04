package ig2i.la2.poo.geocache.infrastructure.mongodb.utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurMongo {
    private String pseudo;
    private String description;
    private String photo;
}
