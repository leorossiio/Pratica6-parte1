package com.example.Pratica4;

public class Aluno {

    private String nome;
    private int cursosConcluidos;
    private boolean premium;

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.premium = false;
    }

    public String getNome() {
        return nome;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public boolean isPremium() {
        return premium; // sempre false
    }

    // stub: não incrementa cursos
    public void registrarParticipacaoNoForum(String mensagem) {
        // todo
    }

    // stub: não faz nada
    public void atualizarPlanoSeElegivel() {
        // todo
    }
}

/*package com.example.Pratica4;

public class Aluno {

    private Long id;
    private String nome;
    private int cursosConcluidos;
    private boolean premium;

    public Aluno() {}

    public Aluno(Long id, String nome, int cursosConcluidos, boolean premium) {
        this.id = id;
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.premium = premium;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
        atualizarPlanoSeElegivel();
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    public void atualizarPlanoSeElegivel() {
        if (this.cursosConcluidos >= 12) {
            this.premium = true;
        }
    }

    public void registrarParticipacaoNoForum(String mensagem) {
        this.cursosConcluidos++;
        atualizarPlanoSeElegivel();
    }
}
*/