package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import ig2i.la2.poo.geocache.infrastructure.mysql.cache.CacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurEntity {

    @Id
    @Column(name = "id_utilisateur")
    private String id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "proprietaire")
    private List<CacheEntity> caches;

}
