package br.edu.ifsuldeminas.mch.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ViewHolder> {
    private List<Servico> servicos;
    public ServicoAdapter(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servico, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Servico servico = servicos.get(position);
        holder.textServico.setText(servico.getNome());
        holder.textValor.setText(String.format("%.2f", servico.getValor()));
    }

    @Override
    public int getItemCount() {
        return servicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textServico;
        TextView textValor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textServico = itemView.findViewById(R.id.text_servico);
            textValor = itemView.findViewById(R.id.text_valor);
        }
    }
}