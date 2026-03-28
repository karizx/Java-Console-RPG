void main() {
    Scanner scanner = new Scanner(System.in);
    Hero gracz = new Hero("Geralt", 100, 25);
    Hero potwor = new Mage("Gandalf", 80, 15);
    IO.println("Witaj na arenie! Przeciwnikiem jest: " + potwor.getName());
    IO.println("--- ROZPOCZYNA SIĘ WALKA ---");
    while (gracz.getHealth() > 0 && potwor.getHealth() > 0) {
        IO.println("\nTwoja tura! Twoje HP: " + gracz.getHealth() + " | HP Przeciwnika: " + potwor.getHealth());
        IO.println("Wybierz akcję:");
        IO.println("1 - Atak mieczem");
        IO.println("2 - Wypij eliksir leczący");
        IO.print("Twój wybór: ");
        int wybor = scanner.nextInt();
        if (wybor == 1) {
            gracz.attack(potwor);
        } else if (wybor == 2) {
            gracz.heal();
        } else {
            IO.println("Zły wybór, tracisz turę ze stresu!");
        }
        if (potwor.getHealth() <= 0) {
            IO.println("🏆 " + potwor.getName() + " pada na ziemię! Wygrywasz!");
            break;
        }
        IO.println("\nTura przeciwnika...");
        potwor.attack(gracz);
        if (gracz.getHealth() <= 0) {
            IO.println("☠️ Niestety, " + gracz.getName() + " ginie. Koniec gry.");
            break;
        }
    }
    scanner.close();
}