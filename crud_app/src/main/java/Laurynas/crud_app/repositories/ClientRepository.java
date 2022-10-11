package Laurynas.crud_app.repositories;

import Laurynas.crud_app.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
