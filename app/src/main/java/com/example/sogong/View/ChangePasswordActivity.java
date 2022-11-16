package com.example.sogong.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sogong.Control.Control;
import com.example.sogong.Control.ControlEdittingInfo_f;
import com.example.sogong.Control.ControlEmailVerification_f;
import com.example.sogong.Control.ControlLogin_f;
import com.example.sogong.R;

import java.util.List;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText passwd_et, passwdcheck_et;
    Button change_button, cancel_button;

    public static int responseCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        // 사용할 컴포넌트 초기화
        passwd_et = findViewById(R.id.passwd_et);
        passwdcheck_et = findViewById(R.id.passwdcheck_et);
        change_button = findViewById(R.id.change_button);
        cancel_button = findViewById(R.id.cancel_button);

        // UI controller
        CP_UI cu = new CP_UI();

        // 비밀번호 변경
        change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwd = passwd_et.getText().toString();
                String passwdcheck = passwdcheck_et.getText().toString();

                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (responseCode == 200) {
                            responseCode = -2;
                            cu.startToast("비밀번호 변경완료");
                            finish();
                        } else if (responseCode == 400) {
                            responseCode = 0;
                        } else if (responseCode == 404) {
                            responseCode = 0;
                        } else if (responseCode == 500) {
                            responseCode = 0;
                        } else if (responseCode == 501) {
                            responseCode = 0;
                        } else if (responseCode == 502) {
                            responseCode = 0;
                        }
                    }
                };

                class NewRunnable implements Runnable {
                    @Override
                    public void run() {
                        int i = 30;
                        while (i > 0) {
                            i--;

                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            runOnUiThread(runnable);
                        }
                    }
                }

                if (responseCode == 0) {
                    responseCode = -1;

                    ControlEdittingInfo_f cef = new ControlEdittingInfo_f();
                    if(passwd.equals(passwdcheck)) {
                        cef.editPassword(passwd);
                    }
                }

                NewRunnable nr = new NewRunnable();
                Thread t = new Thread(nr);
                t.start();
            }

        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class CP_UI implements Control {

        @Override
        public void startToast(String message) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout));
            TextView toast_textview = layout.findViewById(R.id.toast_textview);
            toast_textview.setText(String.valueOf(message));
            Toast toast = new Toast(getApplicationContext());
            //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0); //TODO 메시지가 표시되는 위치지정 (가운데 표시)
            //toast.setGravity(Gravity.TOP, 0, 0); //TODO 메시지가 표시되는 위치지정 (상단 표시)
            toast.setGravity(Gravity.BOTTOM, 0, 50); //TODO 메시지가 표시되는 위치지정 (하단 표시)
            toast.setDuration(Toast.LENGTH_SHORT); //메시지 표시 시간
            toast.setView(layout);
            toast.show();
        }

        @Override
        public void startDialog(int type, String title, String message, List<String> btnTxtList) {

        }

        @Override
        public void changePage(int dest) {

        }

    }
}