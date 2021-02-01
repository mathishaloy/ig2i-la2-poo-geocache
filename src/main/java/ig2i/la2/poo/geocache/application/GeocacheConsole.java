package ig2i.la2.poo.geocache.application;

import ig2i.la2.poo.geocache.domain.GeocacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class GeocacheConsole implements CommandLineRunner {

    private final GeocacheService geocacheService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello there ! Tu veux quelle geocache bg ?");
        String id = scanner.nextLine();
        System.out.println(geocacheService.findGeocache(id));
    }
}
