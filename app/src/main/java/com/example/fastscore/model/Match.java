package com.example.fastscore.model;

public class Match {
    // private: ninguem de fora pode mexer nos dados, medida de seguranca
    private String league;
    private String homeTeam;
    private String awayTeam;
    private String score;

    // Int para imagem - no android, toda imagem ganha um numero ID
    private int homeTeamResId;
    private int awayTeamResId;

    // 3. O CONSTRUTOR (O PREENCHIMENTO)
    // É um metodo especial que tem o mesmo nome da classe
    // Ele roda automaticamente quando você cria um "new Match()".
    // A função dele é receber os dados brutos e guardar nos atributos acima.
    public Match(String league, String homeTeam, String awayTeam, String score, int homeTeamResId, int awayTeamResId){
        this.league = league; // "this.league" é o atributo da classe.
        this.homeTeam = homeTeam; // "homeTeam" (sem this) é o dado que chegou agora.
        this.awayTeam = awayTeam;
        this.score = score;
        this.homeTeamResId = homeTeamResId;
        this.awayTeamResId = awayTeamResId;
    }

    // 4. GETTERS (LEITURA SOMENTE)
    // Como os dados lá em cima são "private", precisamos criar métodos públicos
    // para que o Adapter consiga LER esses dados e mostrar na tela.
    // Nós não criamos "Setters" (para mudar dados) porque, por enquanto, o placar é fixo.
    public String getLeague() {return league; }
    public String getHomeTeam() {return homeTeam; }
    public String getAwayTeam() {return awayTeam;}
    public String getScore() {return score;}
    public int getHomeTeamResId() {return homeTeamResId; }
    public int getAwayTeamResId() {return awayTeamResId;}
}
