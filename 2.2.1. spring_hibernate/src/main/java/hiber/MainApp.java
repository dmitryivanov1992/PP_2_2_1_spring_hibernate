package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



//Задание 4
      User user2 = new User("Ivan", "Petrov", "petrovi@ya.ru");
      Car car2 = new Car("Mercedes", 77);
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("Alex", "Kozov", "kozova@mail.ru");
      Car car3 = new Car("Infiniti", 35);
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("Petr", "Kozlov", "kozlovp@mail.ru");
      Car car4 = new Car("Jeep", 96);
      user4.setCar(car4);
      userService.add(user4);


      System.out.println(userService.getUserByCar("Infiniti",35));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
