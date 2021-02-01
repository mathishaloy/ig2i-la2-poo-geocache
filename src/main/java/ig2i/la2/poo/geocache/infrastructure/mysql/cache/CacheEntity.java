package ig2i.la2.poo.geocache.infrastructure.mysql.cache;

import ig2i.la2.poo.geocache.domain.cache.Etat;
import ig2i.la2.poo.geocache.domain.cache.Nature;
import ig2i.la2.poo.geocache.domain.cache.Type;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cache")
public class CacheEntity {

    @Id
    @Column(name = "id_cache")
    private String id;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "type")
    private Type type;

    @Column(name = "nature")
    private Nature nature;

    @Column(name = "etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity proprietaire;
}
