package com.example.demo_spring.stores.data;
import com.example.demo_spring.stores.Player;
import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Long> {
}
