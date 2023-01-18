package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("user1Car", 1111)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("user2Car", 2222)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("user3Car", 3333)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("user4Car", 4444)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      User user = userService.getUserByCar("user2Car", 2222);
      System.out.println(user);


      context.close();
   }
}
