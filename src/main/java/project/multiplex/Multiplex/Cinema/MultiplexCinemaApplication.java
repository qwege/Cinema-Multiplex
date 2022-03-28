package project.multiplex.Multiplex.Cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import project.multiplex.Multiplex.Cinema.DB.DBConnect;
import project.multiplex.Multiplex.Cinema.DB.Hibernate.ImportDataToDB;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MultiplexCinemaApplication {

	public static void main(String[] args) {
		ImportDataToDB.run();
		SpringApplication.run(MultiplexCinemaApplication.class, args);

	}

}
