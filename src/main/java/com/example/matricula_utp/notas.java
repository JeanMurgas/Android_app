package com.example.matricula_utp;

public class notas {

    public int fotoP, fotoAprob ;

    String materia, semestre, nota;

    public notas( int fotoP, String materia, String semestre, String nota, int fotoAprob) {
        this.fotoP = fotoP;
        this.materia = materia;
        this.semestre = semestre;
        this.nota = nota;
        this.fotoAprob = fotoAprob;
    }

    public int getFotoP() {
        return fotoP;
    }

    public void setFotoP(int fotoP) {
        this.fotoP = fotoP;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getFotoAprob() {
        return fotoAprob;
    }

    public void setFotoAprob(int fotoAprob) {
        this.fotoAprob = fotoAprob;
    }
}
