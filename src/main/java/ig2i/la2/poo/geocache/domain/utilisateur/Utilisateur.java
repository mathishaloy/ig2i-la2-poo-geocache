package ig2i.la2.poo.geocache.domain.utilisateur;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Utilisateur {
    private String id;
    private String pseudo;
    private String description;
    private String photo;
}
