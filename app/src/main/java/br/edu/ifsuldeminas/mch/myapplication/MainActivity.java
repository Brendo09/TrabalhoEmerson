package br.edu.ifsuldeminas.mch.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Servico> servicos;
    private ServicoAdapter adapter;
    private EditText editServico;
    private EditText editValor;
    private TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicos = new ArrayList<>();
        adapter = new ServicoAdapter(servicos);

        RecyclerView recyclerView = findViewById(R.id.recycler_servicos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        editServico = findViewById(R.id.edit_servico);
        editValor = findViewById(R.id.edit_valor);
        Button btnAdicionar = findViewById(R.id.btn_adicionar);
        textTotal = findViewById(R.id.text_total);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarServico();
            }
        });
    }

    private void adicionarServico() {
        String servico = editServico.getText().toString();
        String valorString = editValor.getText().toString().replaceAll("[^0-9-]", "");

        //String valorString = editValor.getText().toString();

        if (!servico.isEmpty() && !valorString.isEmpty()) {
            float valor = Float.parseFloat(valorString);
            Servico novoServico = new Servico(servico, valor);
            servicos.add(novoServico);
            adapter.notifyDataSetChanged();

            editServico.setText("");
            editValor.setText("");

            calcularTotal();
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularTotal() {
        float total = 0;

        for (Servico servico : servicos) {
            total += servico.getValor();
        }

        textTotal.setText(String.format("Total: %.2f", total));
    }
}