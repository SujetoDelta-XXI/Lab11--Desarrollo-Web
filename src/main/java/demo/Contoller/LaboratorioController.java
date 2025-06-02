package demo.Contoller;

import demo.Model.Laboratorio;
import demo.Repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository repo;

    @GetMapping
    public List<Laboratorio> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Laboratorio obtenerPorId(@PathVariable Integer id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Laboratorio guardar(@RequestBody Laboratorio lab) {
        return repo.save(lab);
    }

    @PutMapping("/{id}")
    public Laboratorio actualizar(@PathVariable Integer id, @RequestBody Laboratorio lab) {
        lab.setCodLab(id);
        return repo.save(lab);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
