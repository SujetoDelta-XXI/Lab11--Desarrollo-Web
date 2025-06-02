package demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class OrdenCompra {

    @Id
    @Column(name = "nro_orden_c")
    private Integer nroOrdenC;

    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    private String situacion;
    private Double total;
    private String nroFacturaProv;

    @ManyToOne
    @JoinColumn(name = "cod_lab", referencedColumnName = "cod_lab")
    @JsonBackReference
    private Laboratorio laboratorio;

    // Getters y setters

    public Integer getNroOrdenC() {
        return nroOrdenC;
    }

    public void setNroOrdenC(Integer nroOrdenC) {
        this.nroOrdenC = nroOrdenC;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNroFacturaProv() {
        return nroFacturaProv;
    }

    public void setNroFacturaProv(String nroFacturaProv) {
        this.nroFacturaProv = nroFacturaProv;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
