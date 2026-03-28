import java.util.Random;
public class Mage extends Hero {
    public Mage(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void attack(Hero target) {
        Random rand = new Random();
        int magicDamage = this.getDamage() + rand.nextInt(15);
        System.out.println("🔥 " + this.getName() + " rzuca potężną KULĘ OGNIA w " + target.getName() + " za " + magicDamage + " obrażeń!");
        target.takeDamage(magicDamage);
    }
}