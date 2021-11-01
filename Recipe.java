package Book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipe")
public class Recipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_recipe")
    private int id_recipe;
    @Column(name = "recipe_name")
    private String recipe_name;
    @Column(name = "recipe_time")
    private int recipe_time;
    @Column(name = "recipe_desc")
    private String recipe_desc;
    @Column(name = "energy_value")
    private int energy_value;
    @Column(name = "recipe_img_path")
    private String recipe_img_path;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "recipe_ingridient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingridient_id"))
    private List<Ingridient> ingridientList;

    public Recipe() {
    }
    public void addIngridients(Ingridient ingridient){
        if(ingridientList==null){
            ingridientList=new ArrayList<>();
        }
        ingridientList.add(ingridient);
    }

    public Recipe(String recipe_name, int recipe_time, String recipe_desc, int energy_value, String recipe_img_path) {
        this.recipe_name = recipe_name;
        this.recipe_time = recipe_time;
        this.recipe_desc = recipe_desc;
        this.energy_value = energy_value;
        this.recipe_img_path = recipe_img_path;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id_recipe=" + id_recipe +
                ", recipe_name='" + recipe_name + '\'' +
                ", recipe_time=" + recipe_time +
                ", recipe_desc='" + recipe_desc + '\'' +
                ", energy_value=" + energy_value +
                ", recipe_img_path='" + recipe_img_path + '\'' +
                '}';
    }

    public int getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(int id_recipe) {
        this.id_recipe = id_recipe;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public int getRecipe_time() {
        return recipe_time;
    }

    public void setRecipe_time(int recipe_time) {
        this.recipe_time = recipe_time;
    }

    public String getRecipe_desc() {
        return recipe_desc;
    }

    public void setRecipe_desc(String recipe_desc) {
        this.recipe_desc = recipe_desc;
    }

    public int getEnergy_value() {
        return energy_value;
    }

    public void setEnergy_value(int energy_value) {
        this.energy_value = energy_value;
    }

    public String getRecipe_img_path() {
        return recipe_img_path;
    }

    public void setRecipe_img_path(String recipe_img_path) {
        this.recipe_img_path = recipe_img_path;
    }
}
