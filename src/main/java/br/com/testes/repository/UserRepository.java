package br.com.testes.repository;

import br.com.testes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    User findByName(String name);

    List<User> findByNameLike(String e);

    List<User> findByAge(int age);

    @Query("select u from User u where u.name = ?1 and u.age = ?2")
    List<User> findPodeSerUmNomeQualquer(String name, int age);
    
    @Query(value = "select u.id, u.name, u.age from User u where u.name = ?1 and u.age = ?2", nativeQuery = true)
    List<User> findPodeSerUmNomeQualquerNativeQuery(String name, int age);
}
