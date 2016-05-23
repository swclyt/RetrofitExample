package org.swchalu.retrofitexample;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.swchalu.retrofitexample.model.SZTCallback;
import org.swchalu.retrofitexample.service.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private final String ENDPOINT = "http://113.105.94.35/htyd/";
    private String TAG = MainActivity.class.getName();
    private TextInputEditText et_sztid;
    private TextView tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        et_sztid = (TextInputEditText) findViewById(R.id.et_sztid);
        tv_back = (TextView) findViewById(R.id.tv_back);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
//                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
////                interceptor.
//                OkHttpClient client = new OkHttpClient.Builder()
//                        .addInterceptor(interceptor)
//                        .retryOnConnectionFailure(true)
//                        .connectTimeout(15, TimeUnit.SECONDS)
////                        .addNetworkInterceptor(mTokenInterceptor)
//                        .build();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                String sztid = et_sztid.getText().toString();
                Log.i(TAG, "sztid : " + sztid);
                if (sztid == null || sztid.length() == 0)
                    break;
                Call<SZTCallback> call = apiService.getSZTBalance("checkSZTBalance", sztid);

                call.enqueue(new Callback<SZTCallback>() {
                    @Override
                    public void onResponse(Call<SZTCallback> call, Response<SZTCallback> response) {
                        Log.i(TAG, "onResponse : " + response.toString());
                        SZTCallback sztCallback = response.body();
                        Log.i(TAG, "onResponse : " + sztCallback.toString());
                        tv_back.setText(sztCallback.toString());
                    }

                    @Override
                    public void onFailure(Call<SZTCallback> call, Throwable t) {
                        Log.i(TAG, "onFailure : " + t.getMessage());
                    }
                });
                break;
        }
    }
}
