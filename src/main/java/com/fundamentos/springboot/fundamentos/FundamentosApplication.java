package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public FundamentosApplication(
            @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
            MyBean myBean,
            MyBeanWithDependecy myBeanWithDependecy,
            MyBeanWithProperties myBeanWithProperties,
            UserPojo userPojo,
            UserRepository userRepository
    ) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependecy = myBeanWithDependecy;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ejemplosAnteriores();
        saveUserInDB();

    }

    private void saveUserInDB(){
        User user1 = new User("John", "Jhon@test.com", LocalDate.of(2022, 1, 1));
        User user2 = new User("Xilena", "xilena@test.com", LocalDate.of(2022, 2, 1));
        User user3 = new User("Audith", "audith@test.com", LocalDate.of(2022, 3, 1));
        User user4 = new User("user4", "user4@test.com", LocalDate.of(2022, 4, 1));
        User user5 = new User("user5", "user5@test.com", LocalDate.of(2022, 5, 1));
        User user6 = new User("user6", "user6@test.com", LocalDate.of(2022, 6, 1));
        User user7 = new User("user7", "user7@test.com", LocalDate.of(2022, 7, 1));
        User user8 = new User("user8", "user8@test.com", LocalDate.of(2022, 8, 1));
        User user9 = new User("user9", "user9@test.com", LocalDate.of(2022, 9, 1));
        User user10 = new User("user10", "user10@test.com", LocalDate.of(2022, 10, 1));
        User user11 = new User("user11", "user11@test.com", LocalDate.of(2022, 11, 1));
        User user12 = new User("user12", "user12@test.com", LocalDate.of(2022, 12, 1));

        List<User> listUsers = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12);
        userRepository.saveAll(listUsers);
    }

    private void  ejemplosAnteriores() {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependecy.printWithDependency();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail()+ " - " +userPojo.getPassword());

        try {
            int value = 10/0;
            LOGGER.debug("mi valor: " + value);
        } catch (Exception e) {
            LOGGER.error("Esto es un error al dividir por cero: " + e.getMessage());
        }
    }
}
