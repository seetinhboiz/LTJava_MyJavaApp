/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttn.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "scoredetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scoredetail.findAll", query = "SELECT s FROM Scoredetail s"),
    @NamedQuery(name = "Scoredetail.findById", query = "SELECT s FROM Scoredetail s WHERE s.id = :id"),
    @NamedQuery(name = "Scoredetail.findByName", query = "SELECT s FROM Scoredetail s WHERE s.name = :name"),
    @NamedQuery(name = "Scoredetail.findByValue", query = "SELECT s FROM Scoredetail s WHERE s.value = :value"),
    @NamedQuery(name = "Scoredetail.findByPercent", query = "SELECT s FROM Scoredetail s WHERE s.percent = :percent"),
    @NamedQuery(name = "Scoredetail.findByIdScoresheet", query = "SELECT s FROM Scoredetail s WHERE s.idScoresheet = :idScoresheet"),
    @NamedQuery(name = "Scoredetail.findByActive", query = "SELECT s FROM Scoredetail s WHERE s.active = :active")})
public class Scoredetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private double value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percent")
    private double percent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idScoresheet")
    private int idScoresheet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private short active;

    public Scoredetail() {
    }

    public Scoredetail(Integer id) {
        this.id = id;
    }

    public Scoredetail(Integer id, String name, double value, double percent, int idScoresheet, short active) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.percent = percent;
        this.idScoresheet = idScoresheet;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getIdScoresheet() {
        return idScoresheet;
    }

    public void setIdScoresheet(int idScoresheet) {
        this.idScoresheet = idScoresheet;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scoredetail)) {
            return false;
        }
        Scoredetail other = (Scoredetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ttn.pojo.Scoredetail[ id=" + id + " ]";
    }
    
}
