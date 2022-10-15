package Laurynas.crud_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class GetClientResponseDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private int age;

}
