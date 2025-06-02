package demo.Contoller;

import demo.Model.Laboratorio;
import demo.Model.OrdenCompra;
import demo.Repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository repo;

    @GetMapping
    public List<OrdenCompra> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public OrdenCompra obtenerPorId(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public OrdenCompra guardar(@RequestBody OrdenCompra orden) {
        // Solución: agregamos la orden al laboratorio antes de guardar
        Laboratorio lab = orden.getLaboratorio();
        if (lab != null && lab.getOrdenes() != null) {
            lab.getOrdenes().add(orden);
        }
        return repo.save(orden);
    }

    @PutMapping("/{id}")
    public OrdenCompra actualizar(@PathVariable Integer id, @RequestBody OrdenCompra orden) {
        orden.setNroOrdenC(id);
        return repo.save(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
