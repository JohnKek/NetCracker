package Book;

import Book.entity.Ingridient;
import Book.entity.Recipe;
import Book.entity.Product;
import Book.entity.Day;
import Book.entity.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("test.xml")
                .addAnnotatedClass(Ingridient.class)
                .addAnnotatedClass(Product.class).
                addAnnotatedClass(Recipe.class).
                addAnnotatedClass(Tag.class).
                addAnnotatedClass(Day.class).
                buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

/*
            Tag tag = new Tag("sadas");
            session.save(tag);
            Recipe recipe = session.get(Recipe.class, 1);
            recipe.addTag(tag);

            session.save(recipe);
*/
/*
           Recipe recipe = new Recipe("Poke", 123, "sadas", 112, "3");
           session.save(recipe);
           Day day = session.get(Day.class, 4);
           day.addRecipe(recipe);
           session.save(day);
*/


            session.getTransaction().commit();
        } finally {

        }
    }
}

