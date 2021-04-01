/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JEFRY
 */
@Embeddable
public class EstudiantecursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID_ESTUDIANTE")
    private int studentidEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECTID_CURSO")
    private int subjectidCurso;

    public EstudiantecursoPK() {
    }

    public EstudiantecursoPK(int studentidEstudiante, int subjectidCurso) {
        this.studentidEstudiante = studentidEstudiante;
        this.subjectidCurso = subjectidCurso;
    }

    public int getStudentidEstudiante() {
        return studentidEstudiante;
    }

    public void setStudentidEstudiante(int studentidEstudiante) {
        this.studentidEstudiante = studentidEstudiante;
    }

    public int getSubjectidCurso() {
        return subjectidCurso;
    }

    public void setSubjectidCurso(int subjectidCurso) {
        this.subjectidCurso = subjectidCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentidEstudiante;
        hash += (int) subjectidCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantecursoPK)) {
            return false;
        }
        EstudiantecursoPK other = (EstudiantecursoPK) object;
        if (this.studentidEstudiante != other.studentidEstudiante) {
            return false;
        }
        if (this.subjectidCurso != other.subjectidCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entity.EstudiantecursoPK[ studentidEstudiante=" + studentidEstudiante + ", subjectidCurso=" + subjectidCurso + " ]";
    }
    
}
