package faculdadecursos.curso.com.faculdadecursos;
/**
 * Created by Matheus Rodrigues on 23/04/2018.
 */

public class Curso {



    private String resumo;
    private String faculdade;
    private String curso;

    public Curso(String resumo, String faculdade, String curso){
        this.resumo = resumo;
        this.faculdade = faculdade;
        this.curso = curso;
    }

    public String getResumo(){
        return this.resumo;
    }

    public String getFaculdade(){
        return this.faculdade;
    }

    public String getCursoNome(){
        return this.curso;
    }

}

