package hua.WebApp.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Application {



	public Application() {

	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		//HardCodedData HCD = new HardCodedData();

		//Users harcode

		//password encoded : pass
		//userRepository.save(new User("john","$2a$12$hg4Pga2WLDh4bUcwK09RvOaF10pql2klLBopuy/0CHtnorSwshble",true,"ROLE_STUDENT"));

		//password encoded : pass
	//	userRepository.save(new User("john","$2a$12$hg4Pga2WLDh4bUcwK09RvOaF10pql2klLBopuy/0CHtnorSwshble",true,"ROLE_STUDENT"));

		//password encoded : pass
		//userRepository.save(new User("john","$2a$12$hg4Pga2WLDh4bUcwK09RvOaF10pql2klLBopuy/0CHtnorSwshble",true,"ROLE_STUDENT"));

	}

}
