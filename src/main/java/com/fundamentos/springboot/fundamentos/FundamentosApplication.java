package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    private ComponentDependency componentDependency;
    private MyBeanWithDependecy myBeanWithDependecy;
    private MyBeanWithProperties myBeanWithProperties;
    private MyBean myBean;
    private UserPojo userPojo;
    private UserRepository userRepository;
    private UserService userService;

    public FundamentosApplication(
            @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependecy myBeanWithDependecy,
            MyBeanWithProperties myBeanWithProperties,
            UserPojo userPojo,
            UserRepository userRepository,
            UserService userService
    ) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependecy = myBeanWithDependecy;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ejemplosAnteriores();
        saveUserInDB();
        getInfoJpqlFromUser();
        saveWithErrorTransactional();
    }

    private void getInfoJpqlFromUser() {
        /*
        LOGGER.info("Usuario metodo findByUserEmail" +
                userRepository.findByUserEmail("xilena@test.com")
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        userRepository.findAndSort("user", Sort.by("id").descending()).forEach(LOGGER::info);

        userRepository.findByName("Audith").forEach(LOGGER::info);

        LOGGER.info(userRepository.findByNameAndEmail("Audith", "quintana@test.com")
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

         */

//        userRepository.findByNameLike("%A%").forEach(LOGGER::info);

//         userRepository.findByNameOrEmail("Audith", "xilena@test.com" ).forEach(LOGGER::info);

//        userRepository.findByBirthDateBetween(LocalDate.of(2022,1, 1), LocalDate.of(2022,3, 1))
//                .forEach(LOGGER::info);

//        userRepository.findByNameLikeOrderByIdDesc("%user%").forEach(LOGGER::info);

//        userRepository.findByNameContainingOrderByIdDesc("user").forEach(LOGGER::info);

//        LOGGER.info(userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022, 2, 1), "xilena@test.com")
//                .orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
    }

    private void saveWithErrorTransactional() {

        User test1 = new User("test1", "test1@test.com", LocalDate.now());
        User test2 = new User("test2", "test2@test.com", LocalDate.now());
        User test3 = new User("test3", "test3@test.com", LocalDate.now());
        User test4 = new User("test4", "test4@test.com", LocalDate.now());

        List<User> listUsers = Arrays.asList(test1, test2, test3, test4);

//        List<User> listUsers = Arrays.asList(
//                new User("test1", "test1@test.com", LocalDate.now()),
//                new User("test2", "test2@test.com", LocalDate.now()),
//                new User("test3", "test3@test.com", LocalDate.now()),
//                new User("test4", "test4@test.com", LocalDate.now())
//        );

        try{
            userService.saveTransactional(listUsers);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("Error operacion transaccional");
        }
        userService.getAllUsers().forEach(LOGGER::info);

    }

    private void saveUserInDB() {
        User user1 = new User("Audith", "quintana@test.com", LocalDate.of(2022, 1, 1));
        User user2 = new User("Xilena", "xilena@test.com", LocalDate.of(2022, 2, 1));
        User user3 = new User("Audith", "lonera@test.com", LocalDate.of(2022, 3, 1));
        User user4 = new User("user4", "user4@test.com", LocalDate.of(2022, 4, 1));
        User user5 = new User("user5", "user5@test.com", LocalDate.of(2022, 5, 1));
        User user6 = new User("user6", "user6@test.com", LocalDate.of(2022, 6, 1));
        User user7 = new User("user7", "user7@test.com", LocalDate.of(2022, 7, 1));
        User user8 = new User("user8", "user8@test.com", LocalDate.of(2022, 8, 1));
        User user9 = new User("user9", "user9@test.com", LocalDate.of(2022, 9, 1));
        User user10 = new User("user10", "user10@test.com", LocalDate.of(2022, 10, 1));
        User user11 = new User("user11", "user11@test.com", LocalDate.of(2022, 11, 1));
        User user12 = new User("user12", "user12@test.com", LocalDate.of(2022, 12, 1));

        List<User> listUsers = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
        userRepository.saveAll(listUsers);
    }

    private void ejemplosAnteriores() {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependecy.printWithDependency();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());

        try {
            int value = 10 / 0;
            LOGGER.debug("mi valor: " + value);
        } catch (Exception e) {
            LOGGER.error("Esto es un error al dividir por cero: " + e.getMessage());
        }
    }
}
