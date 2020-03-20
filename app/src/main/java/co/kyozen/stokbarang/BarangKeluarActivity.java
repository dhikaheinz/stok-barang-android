package co.kyozen.stokbarang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarangKeluarActivity extends AppCompatActivity {

    public static final String URL = "http://aplikasistok99.000webhostapp.com/";
    private ProgressDialog progress;

    @BindView(R.id.editTextIDOut) EditText editTextIDOut;
    @BindView(R.id.editTextIDBarang) EditText editTextIDBarang;
    @BindView(R.id.editTextJumlah) EditText editTextJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_keluar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Masukkan Data Keluar");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonKeluar) void dataKeluar(){
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading...");
        progress.show();

        String id_out = editTextIDOut.getText().toString();
        String id_barang = editTextIDBarang.getText().toString();
        String jumlah = editTextJumlah.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.keluar(id_out, id_barang, jumlah);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                fresh();
                if (value.equals("1")){
                    Toast.makeText(BarangKeluarActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BarangKeluarActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(BarangKeluarActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fresh(){
        editTextIDOut.setText("");
        editTextIDBarang.setText("");
        editTextJumlah.setText("");
    }

    @OnClick(R.id.buttonLihatKeluar) void lihatDataKeluar(){
        startActivity(new Intent(BarangKeluarActivity.this, ViewBarangKeluarActivity.class));
    }
}
