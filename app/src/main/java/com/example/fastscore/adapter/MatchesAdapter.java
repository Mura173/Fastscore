package com.example.fastscore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastscore.R;
import com.example.fastscore.model.Match;

import java.util.List;

// Estendemos RecyclerView.Adapter para ganhar os poderes de "Lista Inteligente"
public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    // lista de dados que vai chegar da MainActivity
    private List<Match> matchesList;

    // CONSTRUTOR: Aqui recebemos a lista de jogos
    public MatchesAdapter(List<Match> matchesList){
        this.matchesList = matchesList;
    }

    // 1. ON CREATE: "Cria o Molde"
    // Esse metodo roda quando o Android precisa criar um novo item visual na tela.
    // Ele vai lá no seu "item_match.xml" e infla (transforma em View real).

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // A linha abaixo é padrão: ela pega o XML e cria a View Java
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    // 2. ON BIND: "Preenche os Dados"
    // E aqui que a magica acontece! O Android te dá um espaco vazio (holder) e a posicao (position).
    // Você pega os dados da lista e coloca nos campos de texto/imagem.
    @Override
    public void onBindViewHolder(@NonNull MatchesAdapter.MatchViewHolder holder, int position) {
        // Pega o jogo da vez (ex: Jogo #0, Jogo #1...)
        Match match = matchesList.get(position);

        // Usa os Getters que criamos para preencher a tela
        holder.txtLeague.setText(match.getLeague());
        holder.txtScore.setText(match.getScore());

        // Coloca as imagens
        holder.imgHome.setImageResource(match.getHomeTeamResId());
        holder.imgAway.setImageResource(match.getAwayTeamResId());
    }

    // 3. GET ITEM COUNT: "Quantos são?"
    // O Android precisa saber o tamanho da lista para calcular a barra de rolagem.
    @Override
    public int getItemCount() {
        return matchesList.size();
    }

    // --- CLASSE INTERNA (VIEWHOLDER) ---
    // Essa classe serve apenas para "segurar" as referências dos elementos da tela (IDs).
    // Assim o Android não precisa ficar procurando os IDs toda hora (o que deixaria o app lento).
    public static class MatchViewHolder extends RecyclerView.ViewHolder{

        TextView txtLeague, txtScore;
        ImageView imgHome, imgAway;

        public MatchViewHolder(@NonNull View itemView){
            super(itemView);

            // Aqui conectamos as variáveis Java com os IDs do seu XML (item_match.xml)
            txtLeague = itemView.findViewById(R.id.league);
            txtScore = itemView.findViewById(R.id.txt_Score);
            imgHome = itemView.findViewById(R.id.homeTeam);
            imgAway = itemView.findViewById(R.id.awayTeam);
        }
    }


}
