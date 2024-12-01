package com.example.demo_spring.stores;

import com.example.demo_spring.Team;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id") // Связь с таблицей Team
    private Team team;

    @NotBlank(message = "Имя игрока обязательно")
    @Size(max = 100, message = "Имя не должно превышать 100 символов")
    private String fullName;

    @NotBlank(message = "Позиция обязательна")
    private String position;

    // Конвертация LocalDate в java.sql.Date
    private Date dateOfBirth;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = Date.valueOf(dateOfBirth); // Преобразуем LocalDate в Date
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @NotNull(message = "Рост обязателен")
    private Integer height;

    @NotNull(message = "Вес обязателен")
    private Integer weight;
}

