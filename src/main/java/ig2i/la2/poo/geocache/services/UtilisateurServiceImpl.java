package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurRepository;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur findUtilisateurById(String id) {
        return Optional.ofNullable(utilisateurRepository.findUtilisateurById(id))
                .orElseThrow(() -> new RuntimeException(String.format("Utilisateur %s does not exist", id)));
    }

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void saveAll(List<Utilisateur> utilisateurs) {
        utilisateurRepository.saveAll(utilisateurs);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }
}
