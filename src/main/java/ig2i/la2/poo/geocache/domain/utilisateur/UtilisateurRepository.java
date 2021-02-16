package ig2i.la2.poo.geocache.domain.utilisateur;

import java.util.List;

public interface UtilisateurRepository {

    Utilisateur findUtilisateurById(String id);

    void save(Utilisateur utilisateur);

    List<Utilisateur> findAll();

}
