package My_comm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try {
            // Загружаем конфигурацию Hibernate (hibernate.cfg.xml)
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Открываем сессию
            Session session = sessionFactory.openSession();
            System.out.println("✅ Успешное подключение к базе данных!");

            // Закрываем сессию и фабрику
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            System.err.println("❌ Ошибка подключения к базе данных:");
            e.printStackTrace(); // Вывод stacktrace
        }
    }
}
