package br.com.raijheckinny.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "TEL",nullable = false)
    private Long tel;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "ENDERECO", nullable = false, length = 100)
    private String endereco;

    @Column(name = "NUMERO", nullable = false, length = 100)
    private Long numero;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;
}
