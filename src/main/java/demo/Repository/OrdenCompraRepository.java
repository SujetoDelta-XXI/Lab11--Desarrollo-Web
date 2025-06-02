package demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.Model.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
}
