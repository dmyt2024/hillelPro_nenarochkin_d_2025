import org.PassGen.PassGenerator;

public class MainPass {
    public static void main(String[] args) {
        PassGenerator pg = new PassGenerator();
        String pass = pg.generatePassword(12);
        System.out.println("Your password: " + pass);
    }
}
