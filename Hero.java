import java.util.Random;

public class Hero {
    String name;
    int health;
    int damage;
    int potions = 3;
    public Hero(String name, int health, int baseDamage) {
        this.name = name;
        this.health = health;
        this.damage = baseDamage;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public void takeDamage(int damageTaken) {
        this.health = this.health - damageTaken;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " otrzymuje " + damageTaken + " obrażeń! Pozostałe HP: " + this.health);
    }
    public void attack(Hero target) {
        Random rand = new Random();
        int actualDamage = this.damage - 5 + rand.nextInt(11);
        boolean isCritical = rand.nextInt(100) < 20;
        if (isCritical) {
            actualDamage = actualDamage * 2;
            System.out.println("💥 KRYTYCZNE TRAFIENIE! " + this.name + " atakuje " + target.getName() + " za " + actualDamage + " obrażeń!");
        } else {
            System.out.println("⚔️ " + this.name + " atakuje " + target.getName() + " za " + actualDamage + " obrażeń!");
        }
        target.takeDamage(actualDamage);
    }
    public void heal() {
        if (potions > 0) {
            Random rand = new Random();
            int healAmount = 15 + rand.nextInt(15);
            this.health += healAmount;
            potions--;
            System.out.println("🧪 " + this.name + " wypija eliksir i leczy się za " + healAmount + " HP! (Aktualne HP: " + this.health + ")");
            System.out.println("🎒 Pozostało eliksirów: " + potions);
        } else {
            System.out.println("❌ Nie masz już eliksirów! Tracisz turę ze stresu!");
        }
    }
}