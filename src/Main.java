import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file;
        String fileName = "model.ser";
        String csvFileName = "dictionary/pokemon.csv";


        Model model;

        try {
            file = new File(fileName);

            try (var inputStream = new ObjectInputStream(new FileInputStream(file))) {
                model = (Model) inputStream.readObject();
            } catch (IOException | ClassNotFoundException | ClassCastException e) {
                model = new Model();
            } //end try catch

            Dictionary dictionary = new Dictionary(model, csvFileName, fileName);
            dictionary.createHashMap(model);
            dictionary.load(model);

            boolean run = true;

            //run process
            while (run) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hello This is Pokemon Dictionary!");
                System.out.println("You can search pokemon with pokemon number or pokemon name");
                System.out.println("Please enter pokemon number or pokemon name.");
                String res = sc.nextLine();
                Pokemon pokemon;
                try {
                    int resInt = Integer.parseInt(res);
                    pokemon = model.getPokemonHashMap().get(resInt);



                } catch (NumberFormatException e) {
                    System.out.println(res);
                    pokemon = model.getPokeNameHashMap().get(res);
                }

                if (pokemon != null) {
                    System.out.println("Your pokemon is:");
                    System.out.println(pokemon.toString());
                } else {
                    System.out.println("Specified pokemon does not exist.");
                }
                for (int i = 0; i < 145; i++) {
                    System.out.print("=");
                }
                System.out.println();
                System.out.println("Do you want to continue the program? [Y/else]");
                res = sc.nextLine();
                if (!res.equalsIgnoreCase("y")) {
                    run = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
