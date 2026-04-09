import java.util.Scanner;
void main() {
    Scanner scanner = new Scanner(System.in);
    Hero gracz = new Hero("Geralt", 100, 25);
    Hero potwor = new Mage("Gandalf", 80, 15);
    System.out.println("Witaj na arenie! Przeciwnikiem jest: " + potwor.getName());
    System.out.println("--- ROZPOCZYNA SIĘ WALKA ---");
    while (gracz.getHealth() > 0 && potwor.getHealth() > 0) {
        System.out.println("\nTwoja tura! Twoje HP: " + gracz.getHealth() + " | HP Przeciwnika: " + potwor.getHealth());
        System.out.println("Wybierz akcję:");
        System.out.println("1 - Atak mieczem");
        System.out.println("2 - Wypij eliksir leczący");
        System.out.print("Twój wybór: ");
        int wybor = scanner.nextInt();
        if (wybor == 1) {
            gracz.attack(potwor);
        } else if (wybor == 2) {
            gracz.heal();
        } else {
            System.out.println("Zły wybór, tracisz turę ze stresu!");
        }
        if (potwor.getHealth() <= 0) {
            System.out.println("🏆 " + potwor.getName() + " pada na ziemię! Wygrywasz!");
            break;
        }
        System.out.println("\nTura przeciwnika...");
        potwor.attack(gracz);
        if (gracz.getHealth() <= 0) {
            System.out.println("☠️ Niestety, " + gracz.getName() + " ginie. Koniec gry.");
            break;
        }
    }
    scanner.close();
}
