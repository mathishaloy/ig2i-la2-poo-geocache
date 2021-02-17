package ig2i.la2.poo.geocache.domain.utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur findUtilisateurById(String id);

    void save(Utilisateur utilisateur);

    void saveAll(List<Utilisateur> utilisateurs);

    List<Utilisateur> findAll();

}
