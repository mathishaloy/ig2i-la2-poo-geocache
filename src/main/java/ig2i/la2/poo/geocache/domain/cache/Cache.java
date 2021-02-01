package ig2i.la2.poo.geocache.domain.cache;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cache {
    private String id;
    private String lieu;

    private float latitude;
    private float longitude;

    private Type type;
    private Nature nature;
    private Etat etat;

    private Utilisateur proprietaire;
}
