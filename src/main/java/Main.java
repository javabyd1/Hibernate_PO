import entity.BooksEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Main {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            List<BooksEntity> books =
                    session.createQuery("FROM " + BooksEntity.class.getName()).list();

            for (BooksEntity book : books
                    ) {
                System.out.println(" Autor: " + book.getAuthor());
                System.out.println(" Tytul: " + book.getTitle());

            }
            tx.commit();
//Dodawanie rekordow
            tx = session.beginTransaction();
//
//            BooksEntity booksEntity = new BooksEntity();
//            booksEntity.setAuthor("Witold Witold");
//            booksEntity.setCategory("fantasy");
//            booksEntity.setIsbn("541894123");
//            booksEntity.setOnStock(58);
//            booksEntity.setPageCount(5548);
//            booksEntity.setPublished(Date.valueOf("2000-01-01"));
//            booksEntity.setPublisher("Helion");
//            booksEntity.setTitle("Star Trek");
//            booksEntity.setPrice(BigDecimal.valueOf(59.87));
//            session.save(booksEntity);

            //usuwanie rekordu
            BooksEntity b1 = new BooksEntity();
            b1 = (BooksEntity) session.load(BooksEntity.class, 2);
            session.delete(b1);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            ourSessionFactory.close();
        }
    }
}
