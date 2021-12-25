import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Model implements Serializable {
    private HashMap<Integer, Pokemon> pokemonHashMap;
    private HashMap<String, Pokemon> pokeNameHashMap;

    //constructor
    public Model(HashMap<Integer, Pokemon> pokemonHashMap, HashMap<String, Pokemon> pokeNameHashMap) {
        Objects.requireNonNull(pokemonHashMap);
        this.pokemonHashMap = new HashMap<>(pokemonHashMap);
        this.pokeNameHashMap = new HashMap<>(pokeNameHashMap);
    }


    //constructor
    public Model() {
        this.pokemonHashMap = new HashMap<>();
        this.pokeNameHashMap = new HashMap<>();
    } //Model

    public HashMap<Integer, Pokemon> getPokemonHashMap() {
        return pokemonHashMap;
    }

    public HashMap<String, Pokemon> getPokeNameHashMap() {
        return pokeNameHashMap;
    }

    public void setPokemonHashMap(HashMap<Integer, Pokemon> pokemonHashMap) {
        this.pokemonHashMap = pokemonHashMap;
    }

    public void setPokeNameHashMap(HashMap<String, Pokemon> pokeNameHashMap) {
        this.pokeNameHashMap = pokeNameHashMap;
    }

    //add pokemon method
    public boolean add(Pokemon pokemon) {
        int pokeNum;
        String pokeName;
        Pokemon value;

        Objects.requireNonNull(pokemon, "The specified pokemon is null");
        pokeNum = pokemon.getPokemonNum();
        value = this.pokemonHashMap.putIfAbsent(pokeNum, pokemon);

        if (value == null) {
            return false;
        }

        pokeName = pokemon.getName();
        value = this.pokeNameHashMap.putIfAbsent(pokeName, pokemon);

        return value != null;
    }

    public Pokemon search(int pokeNum) {

        return this.pokemonHashMap.get(pokeNum);
    }

    public Pokemon search(String pokeName) {
        return this.pokeNameHashMap.get(pokeName);
    }

}
