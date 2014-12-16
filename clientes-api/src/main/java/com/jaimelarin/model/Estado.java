package com.jaimelarin.model;
// Generated 12-nov-2014 21:33:00 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", catalog = "app_db"
)
public class Estado implements java.io.Serializable {

    private Integer idEstado;
    private Pais pais;
    private String codEstado;
    private String estado;
    private Set clientes = new HashSet(0);

    public Estado() {
    }

    public Estado(Pais pais, String codEstado, String estado) {
        this.pais = pais;
        this.codEstado = codEstado;
        this.estado = estado;
    }

    public Estado(Pais pais, String codEstado, String estado, Set clientes) {
        this.pais = pais;
        this.codEstado = codEstado;
        this.estado = estado;
        this.clientes = clientes;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_estado", unique = true, nullable = false)
    public Integer getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pais", nullable = false)
    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Column(name = "cod_estado", nullable = false, length = 10)
    public String getCodEstado() {
        return this.codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    @Column(name = "estado", nullable = false, length = 45)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Estado.class, mappedBy = "clientes")
    public Set getClientes() {
        return this.clientes;
    }

    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", pais=" + pais + ", codEstado=" + codEstado + ", estado=" + estado + ", clientes=" + clientes + '}';
    }

}