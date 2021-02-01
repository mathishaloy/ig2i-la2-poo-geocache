package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
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

}
