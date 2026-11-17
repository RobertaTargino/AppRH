package com.apprh.apprh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getters e setters automaticamente
@AllArgsConstructor 
@NoArgsConstructor 
@Entity
@Table(name = "users") // Define o nome da tabela
public class User {

    @Id // Define username como chave primária
    private String username;

    // Permite receber a senha
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String role;

}
