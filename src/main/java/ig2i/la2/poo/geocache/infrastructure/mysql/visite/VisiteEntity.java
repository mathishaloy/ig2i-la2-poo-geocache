package ig2i.la2.poo.geocache.infrastructure.mysql.visite;

import ig2i.la2.poo.geocache.infrastructure.mysql.cache.CacheEntity;
import ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur.UtilisateurEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visite")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisiteEntity {

    @Id
    @Column(name = "id_visite")
    private String id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_cache")
    private CacheEntity cache;
}
