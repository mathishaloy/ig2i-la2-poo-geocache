package ig2i.la2.poo.geocache.domain;

import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.visite.Visite;

public interface RandomDomainBuilder {

    Cache buildCache();

    Visite buildVisite();

    Utilisateur buildUtilisateur();

}
