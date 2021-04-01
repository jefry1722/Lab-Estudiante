/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entity.Estudiantecurso;
import co.edu.unipiloto.entity.EstudiantecursoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JEFRY
 */
@Local
public interface EstudiantecursoFacadeLocal {

    void create(Estudiantecurso estudiantecurso);

    void edit(Estudiantecurso estudiantecurso);

    void remove(Estudiantecurso estudiantecurso);

    Estudiantecurso find(Object id);

    List<Estudiantecurso> findAll();

    List<Estudiantecurso> findRange(int[] range);

    int count();
    
    void insertarEstudianteCurso(int studentidEstudiante, int subjectidCurso, double grade);
    
    Estudiantecurso consultarEstudiantecurso(EstudiantecursoPK pk);
    
}
