package ig2i.la2.poo.geocache.infrastructure.mysql.utilisateur;

import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    private final UtilisateurJpaRepository utilisateurJpaRepository;

    @Override
    public Utilisateur findUtilisateurById(String id) {
        return Optional.ofNullable(utilisateurJpaRepository.getUtilisateurEntityById(id))
                .map(UtilisateurMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurJpaRepository.save(UtilisateurMapper.toEntity(utilisateur));
    }
}
