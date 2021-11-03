package Book.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "user_surname")
    private String user_surname;
    @Column(name = "id_menu")
    private int id_menu;
    @OneToOne
    private Menu menu;
    @Column (name = "user_rights")
    private int user_rights;

    public User() {
    }
    public User(String login, String password, String user_name, String user_surname, int user_rights) {
        this.login = login;
        this.password = password;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_rights = user_rights;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public Menu getId_menu() {
        return menu;
    }

    public void setId_menu(Menu menu) {
        this.menu = menu;
    }

    public int getUser_rights() {
        return user_rights;
    }

    public void setUser_rights(int user_rights) {
        this.user_rights = user_rights;
    }

    public void addMenu(Menu menu){
        if(this.menu==null){
            this.menu=new Menu();
        }
        this.menu = menu;
        this.id_menu = menu.getId_menu();
    }
}
