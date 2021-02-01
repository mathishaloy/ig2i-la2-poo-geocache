package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurJpaRepository extends JpaRepository<UtilisateurEntity, String> {

    UtilisateurEntity getUtilisateurEntityById(String id);

}
