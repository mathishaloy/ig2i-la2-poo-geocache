package ig2i.la2.poo.geocache.domain.utilisateur;

public interface UtilisateurRepository {

    Utilisateur findUtilisateurById(String id);

    void save(Utilisateur utilisateur);

}
