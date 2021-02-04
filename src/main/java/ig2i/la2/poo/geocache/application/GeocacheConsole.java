package ig2i.la2.poo.geocache.application;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class GeocacheConsole implements CommandLineRunner {

    private final CacheService cacheService;

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello there ! Tu veux quelle geocache bg ?");
        String id = scanner.nextLine();

        Request request = cacheService.testFindCacheById(id);
        System.out.println(request.toString());

    }
}
