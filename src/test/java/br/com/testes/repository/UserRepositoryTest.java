package br.com.testes.repository;

import br.com.testes.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    //Query Creation
    @Test
    public void testListarUsuarios(){
        var users = userRepository.findAll();
        System.out.println(users);
        assertThat(users).isNotEmpty();
    }

    @Test
    public void testFindByName(){
        var name = "Teste001";
        userRepository.save(new User(name, 20));
        var user = userRepository.findByName(name);

        assertThat(user).isNotNull();
    }

    @Test
    public void testFindByNameLike(){
        var like = "%e%";
        var result = userRepository.findByNameLike(like);

        assertThat(result).isNotEmpty();
    }


    //Named Queries
    @Test
    public void testFindByAge(){
        var age = 18;
        userRepository.save(new User("Teste Age", age));
        var result = userRepository.findByAge(age);

        assertThat(result).isNotEmpty();
    }

    //@Query
    @Test
    public void testFindByNameAndAge_query(){
        var name = "Augustinho Carrara";
        var age = 23;
        userRepository.save(new User(name, age));
        userRepository.save(new User(name, age));
        var res = userRepository.findPodeSerUmNomeQualquer(name, age);

        assertThat(res).isNotEmpty();

    }
    
    //Native Queries
    @Test
    public void testFindByNameAndAge_nativeQuery(){
        var name = "Augustinho Carrara";
        var age = 23;
        userRepository.save(new User(name, age));
        userRepository.save(new User(name, age));
        var res = userRepository.findPodeSerUmNomeQualquerNativeQuery(name, age);

        assertThat(res).isNotEmpty();
    }

}
