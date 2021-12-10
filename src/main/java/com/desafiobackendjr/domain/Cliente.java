package com.desafiobackendjr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updated_at;

    @JoinColumn(name = "fk_carro")
    @OneToOne(orphanRemoval = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Carro carro;
}