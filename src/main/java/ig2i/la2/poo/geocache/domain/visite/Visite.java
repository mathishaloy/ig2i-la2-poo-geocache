package ig2i.la2.poo.geocache.domain.visite;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Visite {
    private String id;
    private LocalDateTime date;
    private String commentaire;
    private String photo;

    private Utilisateur utilisateur;
    private Cache cache;
}
