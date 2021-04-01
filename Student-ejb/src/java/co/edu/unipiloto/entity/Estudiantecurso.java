/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "ESTUDIANTECURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantecurso.findAll", query = "SELECT e FROM Estudiantecurso e"),
    @NamedQuery(name = "Estudiantecurso.findByStudentidEstudiante", query = "SELECT e FROM Estudiantecurso e WHERE e.estudiantecursoPK.studentidEstudiante = :studentidEstudiante"),
    @NamedQuery(name = "Estudiantecurso.findBySubjectidCurso", query = "SELECT e FROM Estudiantecurso e WHERE e.estudiantecursoPK.subjectidCurso = :subjectidCurso"),
    @NamedQuery(name = "Estudiantecurso.findByGrade", query = "SELECT e FROM Estudiantecurso e WHERE e.grade = :grade")})
public class Estudiantecurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantecursoPK estudiantecursoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GRADE")
    private Double grade;
    @JoinColumn(name = "SUBJECTID_CURSO", referencedColumnName = "SUBJECTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "STUDENTID_ESTUDIANTE", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public Estudiantecurso() {
    }

    public Estudiantecurso(EstudiantecursoPK estudiantecursoPK) {
        this.estudiantecursoPK = estudiantecursoPK;
    }
    
    public Estudiantecurso(EstudiantecursoPK estudiantecursoPK, Double grade) {
        this.estudiantecursoPK = estudiantecursoPK;
        this.grade = grade;
    }

    public Estudiantecurso(int studentidEstudiante, int subjectidCurso) {
        this.estudiantecursoPK = new EstudiantecursoPK(studentidEstudiante, subjectidCurso);
    }

    public EstudiantecursoPK getEstudiantecursoPK() {
        return estudiantecursoPK;
    }

    public void setEstudiantecursoPK(EstudiantecursoPK estudiantecursoPK) {
        this.estudiantecursoPK = estudiantecursoPK;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantecursoPK != null ? estudiantecursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantecurso)) {
            return false;
        }
        Estudiantecurso other = (Estudiantecurso) object;
        if ((this.estudiantecursoPK == null && other.estudiantecursoPK != null) || (this.estudiantecursoPK != null && !this.estudiantecursoPK.equals(other.estudiantecursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.Estudiantecurso[ estudiantecursoPK=" + estudiantecursoPK + " ]";
    }
    
}
