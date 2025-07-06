
package org.example.Entity;

import org.example.Service.GameService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GameEngine {

    private final GameService service;
    private final Scanner scanner = new Scanner(System.in);

    public GameEngine(GameService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            Question q = service.getCurrentQuestion();
            System.out.println("\n" + q.getText());

            if (q.getIsEnd()) break;

            for (Choice c : q.getChoices()) {
                System.out.println(c.getLabel() + ". " + c.getText());
            }

            System.out.print("Choose: ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                service.processChoice(input);
            } catch (Exception e) {
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Thanks for playing.");
    }
}
