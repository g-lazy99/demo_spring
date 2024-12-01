package com.example.demo_spring;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;


@Data
public class Tournament {
    private Long id;

    @NotBlank(message = "Название турнира обязательно")
    private String name;

    @NotNull(message = "Дата проведения обязательна")
    private Date date;

    @NotNull(message = "Список команд обязателен")
    private List<Team> teams;
}
