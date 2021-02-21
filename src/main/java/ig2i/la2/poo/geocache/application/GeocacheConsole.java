package ig2i.la2.poo.geocache.application;

import ig2i.la2.poo.geocache.domain.RandomDomainBuilder;
import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import ig2i.la2.poo.geocache.domain.utilisateur.UtilisateurTestService;
import ig2i.la2.poo.geocache.domain.visite.VisiteTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class GeocacheConsole implements CommandLineRunner {

    private final CacheService cacheService;

    private final UtilisateurTestService utilisateurTestService;

    private final VisiteTestService visiteTestService;

    private final RandomDomainBuilder randomDomainBuilder;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean alive = true;
        while (alive) {
            System.out.println("Liste des commandes :");
            System.out.println("\t- get [object] [id]|all");
            System.out.println("\t- add [object] [number]");
            System.out.println("\t- exit");
            System.out.println("Saisissez votre commande :");
            String command = scanner.nextLine();

            String[] commandSplit = command.split(" ");
            switch (commandSplit[0]) {
                case "get":
                    switch (commandSplit[1]) {
                        case "cache":
                            if (commandSplit[2].equalsIgnoreCase("all"))
                                System.out.println(cacheService.testFindAll());
                            else System.out.println(cacheService.testFindCacheById(commandSplit[2]));
                            break;
                        case "visite":
                            if (commandSplit[2].equalsIgnoreCase("all"))
                                System.out.println(visiteTestService.findAll());
                            else System.out.println(visiteTestService.findVisiteById(commandSplit[2]));
                            break;
                        case "utilisateur":
                            if (commandSplit[2].equalsIgnoreCase("all"))
                                System.out.println(utilisateurTestService.findAll());
                            else System.out.println(utilisateurTestService.findUtilisateurById(commandSplit[2]));
                            break;
                        default:
                            System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                    }
                    break;
                case "add":
                    switch (commandSplit[1]) {
                        case "cache":
                            Request request = cacheService.testAddCaches(Integer.parseInt(commandSplit[2]));
                            System.out.println(request.toString());
                            break;
                        case "visite":
                            System.out.println(visiteTestService.save(randomDomainBuilder.buildVisite()));
                            break;
                        case "utilsateur":
                            System.out.println(utilisateurTestService.save(randomDomainBuilder.buildUtilisateur()));
                            break;
                        default:
                            System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                    }
                    break;
                case "delete":
                    switch (commandSplit[1]) {
                        case "cache":
                            break;
                        case "visite":
                            break;
                        case "utilsateur":
                            break;
                        default:
                            System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                    }
                    break;
                case "exit":
                    alive = false;
                default:
                    System.out.printf("L'action '%s' n'est pas reconnue %n", commandSplit[0]);
            }
        }
    }
}
