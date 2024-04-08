package App;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan({"App.mappers"})
@SpringBootApplication
public class Starter {
    public static void main(String[] args)  {
        SpringApplication.run(Starter.class,args);

    }

}
