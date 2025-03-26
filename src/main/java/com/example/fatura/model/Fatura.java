package com.example.fatura.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="fatura")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Pattern(regexp="\\{16}", message = "A conta deve conter 16 caracteres!")
    private String numeroCartao;

    @NotBlank
    @Size(min=3, max=100, message = "O nome deve possuir entre 3 e 100 caracteres!")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser nulo!")
    @DecimalMin(value = "10.00", message = "O valor minimo é 10 reais!")
    @DecimalMax(value = "5000", message = "O valor máximo é 5.000!")
    private Double valor;

    @NotNull(message = "A data não pode ser Nula!")
    @FutureOrPresent(message = "A data deve ser a atual ou futura!")
    private LocalDate dataPagamento;

    @NotBlank
    @Email(message = "O email deve ser válido!")
    private String emailContato;
}
