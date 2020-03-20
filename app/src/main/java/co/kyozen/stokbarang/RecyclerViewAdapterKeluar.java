package co.kyozen.stokbarang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapterKeluar extends RecyclerView.Adapter<RecyclerViewAdapterKeluar.ViewHolder> {

    private Context context;
    private List<Result> results;

    public RecyclerViewAdapterKeluar(Context context, List<Result> results) {
        this.results = results;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_keluar, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = results.get(position);
        holder.textViewIDOut.setText(result.getId_out());
        holder.textViewIDBarang.setText(result.getId_barang());
        holder.textViewJumlahKeluar.setText(result.getJumlah());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textIDOut) TextView textViewIDOut;
        @BindView(R.id.textIDBarang) TextView textViewIDBarang;
        @BindView(R.id.textJumlahKeluar) TextView textViewJumlahKeluar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
