package com.example.demo_spring.stores.data;
import com.example.demo_spring.Tournament;
import org.springframework.data.repository.CrudRepository;


public interface TournamentRepository extends CrudRepository<Tournament, Long> {
}
