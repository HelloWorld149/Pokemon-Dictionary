import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Dictionary implements Serializable {
    private Model model = new Model();
    private String csvFileName;
    private String modelFileName;
    private int version;

    public Dictionary(Model model, String csvFileName, String modelFileName) {
        this.model = model;
        this.csvFileName = csvFileName;
        this.modelFileName = modelFileName;
        this.version = -1;
    }



    public void createHashMap(Model model) throws Exception{
        HashMap<Integer, Pokemon> pokeNumHash = new HashMap<>();
        HashMap<String, Pokemon> pokeNameHash = new HashMap<>();

        BufferedReader bfr = new BufferedReader(new FileReader(csvFileName));
        String line;

        bfr.readLine(); //skip first line.

        while ((line = bfr.readLine()) != null )   //if string builder is not empty
        {
            String[] info = line.split(",");    // use comma as separator
            Pokemon pokemon = new Pokemon(Integer.parseInt(info[0]), info[1], info[2], info[3],
                    Integer.parseInt(info[4]), Integer.parseInt(info[5]),
                    Integer.parseInt(info[6]), Integer.parseInt(info[7]),
                    Integer.parseInt(info[8]), Integer.parseInt(info[9]),
                    Integer.parseInt(info[10]), Integer.parseInt(info[11]),
                    Boolean.parseBoolean(info[12]));

                    model.add(pokemon);
        }

        File file = new File(this.modelFileName);
        if (!file.exists()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Download is needed to use this app. Do you want to continue? [Y/else]");

            if (!sc.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Program is terminated.");
                System.exit(0);
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeInt(1);  //write version.
        oos.writeObject(model.getPokemonHashMap());
        oos.writeObject(model.getPokeNameHashMap());

        oos.flush();
        oos.close();
    }

    public void load(Model model) throws Exception {
        File f = new File(this.modelFileName);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        this.version = ois.readInt();
        model.setPokemonHashMap((HashMap<Integer, Pokemon>) ois.readObject());
        model.setPokeNameHashMap((HashMap<String, Pokemon>) ois.readObject());
    }




}
