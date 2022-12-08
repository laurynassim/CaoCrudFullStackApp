package Laurynas.crud_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateClientRequestDTO {
    private String name;
    private String surname;
    private String email;
    private int age;

    private String dateOfBirth;

    @Override
    public String toString() {
        return "CreateClientRequestDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
