package ig2i.la2.poo.geocache.infrastructure.mongodb.visite;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VisiteMongo {
    private String id;
    private LocalDateTime date;
    private String commentaire;
    private String photo;
}
