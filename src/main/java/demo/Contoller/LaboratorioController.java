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

    @PostMapping
    public Laboratorio guardar(@RequestBody Laboratorio lab) {
        return repo.save(lab);
    }
}
