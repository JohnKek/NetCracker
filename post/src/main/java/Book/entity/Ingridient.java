package Book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingridient")
public class Ingridient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingridient")
    private int id;
    @Column(name = "weight")
    private int weight;


    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "recipe_ingridient",
            joinColumns = @JoinColumn(name = "ingridient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipeList;


    public void addRecipe(Recipe recipe){
        if(recipeList==null){
            recipeList=new ArrayList<>();
        }
        recipeList.add(recipe);
    }


    public Ingridient() {
    }

    public Ingridient(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ingridient{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
