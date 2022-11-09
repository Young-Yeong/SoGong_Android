package com.example.sogong.View;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sogong.Model.User;
import com.example.sogong.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    // 로그에 사용할 TAG 변수 선언
    final private String TAG = getClass().getSimpleName();

    // 사용할 컴포넌트 선언
    EditText userid_et, passwd_et;
    Button login_button, join_button;
    TextInputLayout textInputLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 사용할 컴포넌트 초기화
        userid_et = findViewById(R.id.userid_et);
        passwd_et = findViewById(R.id.passwd_et);
        login_button = findViewById(R.id.login_button);
        join_button = findViewById(R.id.join_button);
        textInputLayout2 = findViewById(R.id.textInputLayout2);

        // 로그인 버튼 이벤트 추가
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {
        RetrofitService sv = RetrofitClient.getClient().create(RetrofitService.class);
        Call<User> call = sv.Login(new User(null, userid_et.getText().toString(), passwd_et.getText().toString(), null, false));//, 0));

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // 반응 제대로 옴
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                                /*
                                할일
                                로그인해서, 답이오면 코드가 200에 내용물들은 body()에 있을것이다. 그건 body().getX()로 가져올 수 있따
                                만약 로그인이 실패했다면 code가 200인데 body에 뭐가 없을것이다
                                 */
                        if (response.code() == 200) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    } else
                        Log.d("empty_response", "with login");

                    //Toast.makeText(LoginActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                } else {
                    // 안옴
                    String result = response.toString();
                    String[] results = result.split(",");
                    //Log.d("sex", results[1]);
                    Toast.makeText(LoginActivity.this, results[1], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/*
class LoginTask extends AsyncTask<String, Void, String> {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                    Log.d(TAG, "onPreExecute");
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    Log.d(TAG, "onPostExecute, " + result);

                    if (result.equals("success")) {
// 결과값이 success 이면
// 토스트 메시지를 뿌리고
// userid 값을 가지고 ListActivity 로 이동
                        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, BoardListActivity.class);
                        intent.putExtra("userid", userid_et.getText().toString());
                        startActivity(intent);
                    } else if (result.equals("fail")) {
                        textInputLayout2.setError("로그인실패");
                        Toast.makeText(LoginActivity.this, "잘못된 정보입니다.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                protected String doInBackground(String... params) {

                    String userid = params[0];
                    String passwd = params[1];

                    //final String[] result = {""};

                    RetrofitService retrofitService = RetrofitClient.getClient().create(RetrofitService.class);
                    Call<User> call = retrofitService.getLogin(userid);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            String result = "";
                            if (response.isSuccessful()) {
                                User user = response.body();
                                Log.d("성공", user.getUserId());
                                if (passwd.equals(user.getPassword())) {
                                    Log.d("성공", "비밀번호 일치");
                                    result = "success";
                                } else {
                                    Log.d("실패", "비밀번호 불일치");
                                    result += "fail";

                                }
                                ;

                            } else {
                                Log.d("실패", "없는 사용자 아이디 입니다.");
                                result += "fail";
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
                    String result = "success";
                    return result;
                }
            }
 */
/*
// 조인 버튼 이벤트 추가
                join_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                        //startActivity(intent);
                    }
                });
 */