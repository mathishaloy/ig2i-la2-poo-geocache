package ig2i.la2.poo.geocache.domain.user;


import ig2i.la2.poo.geocache.domain.cache.Cache;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    private String id;
    private String pseudo;
    private String description;

    private List<Cache> caches;
}
