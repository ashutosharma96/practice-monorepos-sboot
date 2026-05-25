import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootPractice {


    public static void main(String a[]){

        ApplicationContext context = SpringApplication.run(SpringBootPractice.class,a);
        Alien obj=context.getBean(Alien.class);
        obj.code();

}

}
