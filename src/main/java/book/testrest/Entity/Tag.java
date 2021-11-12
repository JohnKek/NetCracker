package book.testrest.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private int id;
    @Column(name = "tag_name")
    private String tag_name;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "recipe_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipeList;


    public void addRecipe(Recipe recipe){
        if(recipeList==null){
            recipeList=new ArrayList<>();
        }
        recipeList.add(recipe);
    }


    public Tag() {
    }
    public Tag(String tag_name) {
        this.tag_name = tag_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tag_name;
    }

    public void setTagName(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag_name=" + tag_name +
                '}';
    }
}
