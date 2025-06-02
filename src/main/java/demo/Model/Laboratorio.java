package demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laboratorio {

    @Id
    @Column(name = "cod_lab")
    private Integer codLab;

    private String razonSocial;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;

    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrdenCompra> ordenes = new ArrayList<>();

    // Getters y setters

    public Integer getCodLab() {
        return codLab;
    }

    public void setCodLab(Integer codLab) {
        this.codLab = codLab;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<OrdenCompra> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenCompra> ordenes) {
        this.ordenes = ordenes;
    }
}
