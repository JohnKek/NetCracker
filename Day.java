package Book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "day")
public class Day {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_day")
    private int id_day;
    @Column(name = "day_name")
    private String day_name;



    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "day_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "day_id"))
    private List<Recipe> recipeList;

    public Day() {
    }
    public void addRecipe(Recipe recipe){
        if(recipeList==null){
            recipeList=new ArrayList<>();
        }
        recipeList.add(recipe);
    }

    public Day(String day_name) {this.day_name = day_name;}

    @Override
    public String toString() {
        return "Day{" +
                "id_day=" + id_day +
                ", day_name='" + day_name +
                '}';
    }


    public void addList(Recipe recipe){
        if(recipeList == null){
            recipeList = new ArrayList<>();
        }
        recipeList.add(recipe);
    }
    public int getId() {
        return id_day;
    }

    public void setId(int id) {
        this.id_day = id_day;
    }

    public String getDayName() {
        return day_name;
    }

    public void setDayName(String day_name) {
        this.day_name = day_name;
    }
}