package Book;

import Book.entity.Ingridient;
import Book.entity.Recipe;
import Book.entity.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("test.xml")
                .addAnnotatedClass(Ingridient.class)
                .addAnnotatedClass(product.class).
                addAnnotatedClass(Recipe.class).
                buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
           /* product product=new product("Bomba",105,95,800,15);
            Ingridient ingridient=new Ingridient(450);
            product.addIngridient(ingridient);
            session.save(product);*/
            Recipe recipe = session.get(Recipe.class,3);
            Ingridient ingridient=session.get(Ingridient.class,2);
            recipe.addIngridients(ingridient);
            session.save(recipe);
            session.getTransaction().commit();
        } finally {

        }
    }
}

