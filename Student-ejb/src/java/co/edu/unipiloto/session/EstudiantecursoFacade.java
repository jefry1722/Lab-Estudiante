/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entity.Estudiantecurso;
import co.edu.unipiloto.entity.EstudiantecursoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JEFRY
 */
@Stateless
public class EstudiantecursoFacade extends AbstractFacade<Estudiantecurso> implements EstudiantecursoFacadeLocal {

    @PersistenceContext(unitName = "Student-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantecursoFacade() {
        super(Estudiantecurso.class);
    }
    
    @Override
    public void insertarEstudianteCurso(int studentidEstudiante, int subjectidCurso, double grade) {
        
        EstudiantecursoPK pk = new EstudiantecursoPK(studentidEstudiante, subjectidCurso);
        if(consultarEstudiantecurso(pk)==null){
            Estudiantecurso ec = new Estudiantecurso(pk, grade);
            em.persist(ec);
        }
    }

    @Override
    public Estudiantecurso consultarEstudiantecurso(EstudiantecursoPK pk) {
        return em.find(Estudiantecurso.class, pk);
    }
    
}
