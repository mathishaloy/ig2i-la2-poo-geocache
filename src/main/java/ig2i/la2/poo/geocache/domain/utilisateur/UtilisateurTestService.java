package ig2i.la2.poo.geocache.domain.utilisateur;

import ig2i.la2.poo.geocache.domain.Request;

import java.util.List;

public interface UtilisateurTestService {
    Request findUtilisateurById(String id);

    Request save(Utilisateur utilisateur);

    Request saveAll(List<Utilisateur> utilisateurs);

    Request findAll();
}
