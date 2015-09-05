package br.com.mrcsfelipe.testando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by u6448938 on 07/07/2015.
 */
public class LoginActivity extends Activity {

    private EditText login, senha;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (EditText) findViewById(R.id.etLogin);
        senha = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.bntLogin);

    }

    public void entrar(View view){

        if(login.getText().toString().equals("admin")){
            if(senha.getText().toString().equals("admin")){
                Intent intent = new Intent(this, Index.class);
                startActivity(intent);
            }
        }

    }

}
