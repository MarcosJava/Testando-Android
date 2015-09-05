package br.com.mrcsfelipe.testando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import br.com.mrcsfelipe.testando.entity.Testando;
import br.com.mrcsfelipe.testando.entity.Usuario;

/**
 * Created by u6448938 on 06/07/2015.
 */
public class Index extends Activity {

    private TextView tvCadastrar, tvListar;
    private RelativeLayout rlIndex;
    private GestureDetector detector = null;
    private float x = 48, y =109;





    private boolean cadastrar =true , listar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        tvCadastrar = (TextView) findViewById(R.id.tvCadastrar);
        tvListar = (TextView) findViewById(R.id.tvListar);
        rlIndex = (RelativeLayout) findViewById(R.id.rlIndex);

        for(Usuario u : CadastrarUsuarioActivity.usuarios){
            Log.i("usuario", u.getEmail());
        }

        /*

        tvCadastrar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String touch = event.toString();

                Log.i("Teste",touch);

                if(x > event.getX() && y < event.getY()){
                    Log.i("touch", "Dedo para esquerda");

                    //if(cadastrar){
                        cadastro();
                       // cadastrar = false;
                   // }



                } else {
                    Log.i("touch", "Dedo para direita");
                    //listagem();
                }

                return true;
            }
        });
        tvListar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String touch = event.toString();

                Log.i("Teste",touch);

                if(x > event.getX() && y < event.getY()){
                    Log.i("touch", "Dedo para esquerda");
                    //cadastro();


                } else {
                    Log.i("touch", "Dedo para direita");
                    listagem();
                }

                return true;
            }
        });
        */

    }

    public void cadastro(){
        startActivity(new Intent(this, CadastrarUsuarioActivity.class));

    }
    public void listagem(){
        startActivity(new Intent(this, ListarUsuario.class));
    }

    public void opcaoSelecionada(View view) {
        TextView textView = (TextView) view;
        String opcao = "Opção: " + textView.getText().toString();
        Toast.makeText(this, opcao, Toast.LENGTH_LONG).show();


        switch (view.getId()) {
            case R.id.tvCadastrar:
                startActivity(new Intent(this, CadastrarUsuarioActivity.class));
                break;
            case R.id.tvListar:
                startActivity(new Intent(this, ListarUsuario.class));
                break;
        }
    }

}
