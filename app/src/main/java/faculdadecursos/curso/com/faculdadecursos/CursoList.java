package faculdadecursos.curso.com.faculdadecursos;

import java.util.LinkedList;
import java.util.List;

public class CursoList {


    List<Curso> cursos = new LinkedList<>();
    Connection connection = new Connection();

    public void getCursos(){
        try {
            cursos = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnAllFaculdades(){
        List<String> faculdades = new LinkedList<>();
        for(Curso curso:cursos){
            faculdades.add(curso.getFaculdade());
        }
        return faculdades;
    }

    public List<String> returnCursosByFaculdade(String faculdade){
        List<String> found = new LinkedList<String>();
        for(Curso curso: cursos){
            if(curso.getFaculdade().equals(faculdade)) found.add(curso.getCursoNome());
        }
        return found;
    }

    public String returnResumos(String faculdade, String cursoNome){
        for(Curso curso: cursos){
            if(curso.getFaculdade().equals(faculdade) && curso.getCursoNome().equals(cursoNome)) return curso.getResumo();
        }
        return "Sorry...";
    }
}