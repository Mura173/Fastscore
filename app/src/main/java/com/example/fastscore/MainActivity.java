package com.example.fastscore;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastscore.adapter.MatchesAdapter;
import com.example.fastscore.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Encontrar o RecyclerView na tela
        RecyclerView rvMatches = findViewById(R.id.rvMatches);

        // 2. Definir que a lista é VERTICAL (LinearLayoutManager)
        // Sem isso, o app não sabe como desenhar a lista e não mostra nada!
        rvMatches.setLayoutManager(new LinearLayoutManager(this));

        // 3. Criar a lista de dados falsos (Mock Data)
        // Aqui simulamos os dados que viriam da internet
        List<Match> listaJogos = new ArrayList<>();

        // Adicionando jogos (Certifique-se que as imagens R.drawable existem!)
        listaJogos.add(new Match("La Liga", "Barcelona", "Real madrid", "3 - 0", R.drawable.logo_barcelona, R.drawable.logo_realmadrid));
        listaJogos.add(new Match("Premiere League", "Liverpool", "Chelsea", "1 - 2", R.drawable.logo_liverpool, R.drawable.logo_chelsea));
        listaJogos.add(new Match("Brasileirao", "Corinthians", "Palmeiras", "4 - 1", R.drawable.logo_corinthians, R.drawable.logo_palmeiras));
        listaJogos.add(new Match("Serie A", "Milan", "Roma", "1 - 1", R.drawable.logo_milan, R.drawable.logo_roma));
        listaJogos.add(new Match("Liga Profesional", "Boca Juniors", "River Plate", "2 - 3", R.drawable.logo_boca, R.drawable.logo_river));

        // 4. Criar o Adapter e passar a lista para ele
        MatchesAdapter adapter = new MatchesAdapter(listaJogos);

        // 5. Ligar o Adapter ao RecyclerView
        rvMatches.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}