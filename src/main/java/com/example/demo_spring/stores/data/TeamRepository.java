package com.example.demo_spring.stores.data;
import com.example.demo_spring.Team;
import org.springframework.data.repository.CrudRepository;


public interface TeamRepository extends CrudRepository<Team, Long> {
}
