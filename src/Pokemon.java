import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Pokemon implements Serializable {
    private int pokemonNum;
    private String name;
    private String type_one;
    private String type_two;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int sp_atk;
    private int sp_def;
    private int speed;
    private int generation;
    private boolean legendary;


    public Pokemon(int pokemonNum, String name, String type_one, String type_two, int total, int hp,
                   int attack, int defense, int sp_atk, int sp_def, int speed,
                   int generation, boolean legendary) {
        this.pokemonNum = pokemonNum;
        this.name = name;
        this.type_one= type_one;
        this.type_two = type_two;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_atk = sp_atk;
        this.sp_def = sp_def;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    public int getPokemonNum() {
        return pokemonNum;
    }

    public void setPokemonNum(int pokemonNum) {
        this.pokemonNum = pokemonNum;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean getLegendary() {
        return legendary;
    }

    public int getSp_atk() {
        return sp_atk;
    }

    public int getSp_def() {
        return sp_def;
    }

    public int getSpeed() {
        return speed;
    }

    public int getTotal() {
        return total;
    }

    public String getType_one() {
        return type_one;
    }

    public String getType_two() {
        return type_two;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public void setSp_atk(int sp_atk) {
        this.sp_atk = sp_atk;
    }

    public void setSp_def(int sp_def) {
        this.sp_def = sp_def;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setType_one(String type_one) {
        this.type_one = type_one;
    }

    public void setType_two(String type_two) {
        this.type_two = type_two;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return total == pokemon.total && hp == pokemon.hp && attack == pokemon.attack
                && defense == pokemon.defense && sp_atk == pokemon.sp_atk
                && sp_def == pokemon.sp_def && speed == pokemon.speed
                && generation == pokemon.generation && legendary == pokemon.legendary
                && Objects.equals(name, pokemon.name) && Objects.equals(type_one, pokemon.type_one)
                && Objects.equals(type_two, pokemon.type_two);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonNum=" + pokemonNum +
                ", name: '" + name + '\'' +
                ", type one: '" + type_one + '\'' +
                ", type two:'" + type_two + '\'' +
                ", total: " + total +
                ", hp: " + hp +
                ", attack: " + attack +
                ", defense: " + defense +
                ", sp_atk: " + sp_atk +
                ", sp_def: " + sp_def +
                ", speed: " + speed +
                ", generation: " + generation +
                ", legendary: " + legendary +
                '}';
    }
}
