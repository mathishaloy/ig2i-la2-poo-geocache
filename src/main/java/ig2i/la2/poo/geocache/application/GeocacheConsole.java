package ig2i.la2.poo.geocache.application;

import ig2i.la2.poo.geocache.domain.Request;
import ig2i.la2.poo.geocache.domain.cache.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class GeocacheConsole implements CommandLineRunner {

    private final CacheService cacheService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Liste des commandes :");
            System.out.println("\t- get [object] id");
            System.out.println("\t- add [object] number");
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
                            break;
                        case "utilsateur":
                            break;
                        default:
                            System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                            throw new IllegalArgumentException("Objet invalide");
                    }
                    break;
                case "add":
                    switch (commandSplit[1]) {
                        case "cache":
                            Request request = cacheService.testAddCaches(Integer.parseInt(commandSplit[2]));
                            System.out.println(request.toString());
                            break;
                        case "visite":
                            break;
                        case "utilsateur":
                            break;
                        default:
                            System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                            throw new IllegalArgumentException("Objet invalide");
                    }
                    break;
                case "delete":
                    break;
                case "update":
                    break;
                default:
                    System.out.printf("L'action '%s' n'est pas reconnue %n", commandSplit[0]);
                    throw new IllegalArgumentException("Action invalide");
            }
        }
    }
}
