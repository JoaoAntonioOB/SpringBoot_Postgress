package Sistema_Bancario_Simples.demo.repository;

import Sistema_Bancario_Simples.demo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
