/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findBySubjectid", query = "SELECT c FROM Curso c WHERE c.subjectid = :subjectid"),
    @NamedQuery(name = "Curso.findByName", query = "SELECT c FROM Curso c WHERE c.name = :name"),
    @NamedQuery(name = "Curso.findByCreditnumber", query = "SELECT c FROM Curso c WHERE c.creditnumber = :creditnumber"),
    @NamedQuery(name = "Curso.findBySemester", query = "SELECT c FROM Curso c WHERE c.semester = :semester"),
    @NamedQuery(name = "Curso.findByAdmitedstudents", query = "SELECT c FROM Curso c WHERE c.admitedstudents = :admitedstudents")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECTID")
    private Integer subjectid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREDITNUMBER")
    private Integer creditnumber;
    @Column(name = "SEMESTER")
    private Integer semester;
    @Column(name = "ADMITEDSTUDENTS")
    private Integer admitedstudents;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Estudiantecurso> estudiantecursoCollection;

    public Curso() {
    }

    public Curso(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Curso(Integer subjectid, String name, Integer creditnumber, Integer semester, Integer admitedstudents) {
        this.subjectid = subjectid;
        this.name = name;
        this.creditnumber = creditnumber;
        this.semester = semester;
        this.admitedstudents = admitedstudents;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(Integer creditnumber) {
        this.creditnumber = creditnumber;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getAdmitedstudents() {
        return admitedstudents;
    }

    public void setAdmitedstudents(Integer admitedstudents) {
        this.admitedstudents = admitedstudents;
    }

    @XmlTransient
    public Collection<Estudiantecurso> getEstudiantecursoCollection() {
        return estudiantecursoCollection;
    }

    public void setEstudiantecursoCollection(Collection<Estudiantecurso> estudiantecursoCollection) {
        this.estudiantecursoCollection = estudiantecursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectid != null ? subjectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.subjectid == null && other.subjectid != null) || (this.subjectid != null && !this.subjectid.equals(other.subjectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.Curso[ subjectid=" + subjectid + " ]";
    }
    
}
