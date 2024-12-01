package com.example.demo_spring;

import com.example.demo_spring.stores.Player;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название команды обязательно")
    @Size(max = 50, message = "Название не должно превышать 50 символов")
    private String name;

    @NotBlank(message = "Имя тренера обязательно")
    private String coach;

    @NotBlank(message = "Страна обязательна")
    private String country;

    @NotNull(message = "Год основания обязателен")
    private Integer foundationYear;

    @OneToMany
    @JoinColumn(name = "team_id") // В таблице Player должно быть поле team_id
    private List<Player> players;
}
