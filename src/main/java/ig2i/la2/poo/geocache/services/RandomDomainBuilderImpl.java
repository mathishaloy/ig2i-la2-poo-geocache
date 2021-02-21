package ig2i.la2.poo.geocache.services;

import ig2i.la2.poo.geocache.domain.RandomDomainBuilder;
import ig2i.la2.poo.geocache.domain.cache.Cache;
import ig2i.la2.poo.geocache.domain.utilisateur.Utilisateur;
import ig2i.la2.poo.geocache.domain.visite.Visite;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RandomDomainBuilderImpl implements RandomDomainBuilder {
    @Override
    public Cache buildCache() {
        return Cache.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public Visite buildVisite() {
        return Visite.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public Utilisateur buildUtilisateur() {
        return Utilisateur.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }
}
