package Book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private int id_menu;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_day")
    private List<Day> dayList;

    public Menu() {
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public void addDay(Day day){
        if(dayList==null){
            dayList=new ArrayList<>();
        }
        dayList.add(day);
    }
}
