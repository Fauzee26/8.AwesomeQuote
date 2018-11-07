package fauzi.hilmy.awesomequote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fauzi.hilmy.awesomequote.api.ApiClient;
import fauzi.hilmy.awesomequote.api.ApiInterface;
import fauzi.hilmy.awesomequote.model.ResponseQuote;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtAuthor)
    TextView txtAuthor;
    @BindView(R.id.txtQuote)
    TextView txtQuote;
    @BindView(R.id.btnRandom)
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadQuote();
    }

    @OnClick(R.id.btnRandom)
    public void onViewClicked() {
        loadQuote();
    }

    private void loadQuote() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseQuote> call = apiService.getQuote();

        call.enqueue(new Callback<ResponseQuote>() {
            @Override
            public void onResponse(Call<ResponseQuote> call, Response<ResponseQuote> response) {
                txtAuthor.setText(response.body().getQuote().getAuthor());
                txtQuote.setText(response.body().getQuote().getBody());
            }

            @Override
            public void onFailure(Call<ResponseQuote> call, Throwable t) {

            }
        });
    }
}
