package br.com.example.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity //informando que é uma entidade de bd
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//gerando id automatico
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "cpf")
    @NotBlank
    private String cpf;
}
