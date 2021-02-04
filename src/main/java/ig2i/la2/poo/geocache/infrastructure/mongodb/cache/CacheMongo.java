package ig2i.la2.poo.geocache.infrastructure.mongodb.cache;

import ig2i.la2.poo.geocache.domain.cache.Etat;
import ig2i.la2.poo.geocache.domain.cache.Nature;
import ig2i.la2.poo.geocache.domain.cache.Type;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "geocacheshmat")
public class CacheMongo {
    @Id
    private String id;
    private String lieu;

    private Float latitude;
    private Float longitude;

    private Type type;
    private Nature nature;
    private Etat etat;
}
