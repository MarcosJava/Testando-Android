package br.com.mrcsfelipe.testando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.testando.entity.Usuario;

/**
 * Created by u6448938 on 01/07/2015.
 */
public class UsuarioCadastrado extends Activity{


    public static List<Usuario> usuarios = new ArrayList<>();

    public static final String EXTRA_NOME_USUARIO= "helloandroid.EXTRA_NOME_USUARIO";

    public static final String EXTRA_EMAIL= "helloandroid.EXTRA_EMAIL";

    public static final String ACAO_EXIBIR_SAUDACAO="helloandroid.ACAO_EXIBIR_SAUDACAO";

    public static final String CATEGORIA_SAUDACAO="helloandroid.CATEGORIA_SAUDACAO";


    private Button confirmar;
    TextView saudacaoTextView, confirmEmail;
    private Usuario u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saudacao);

        saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);

        confirmEmail = (TextView) findViewById(R.id.confirmEmail);

        confirmar = (Button) findViewById(R.id.bntConfirmar);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_NOME_USUARIO)) {
            String saudacao = getResources().getString(R.string.saudacao);
            saudacaoTextView.setText(saudacao + ": " +
                    intent.getStringExtra(EXTRA_NOME_USUARIO));

            confirmEmail.setText("Confirmando o email : " + intent.getStringExtra(EXTRA_EMAIL));

            u = new Usuario(intent.getStringExtra(EXTRA_NOME_USUARIO) ,
                            intent.getStringExtra(EXTRA_EMAIL));

        } else {
            saudacaoTextView.setText("O nome do usuário não foi informado");
        }




    }

    public void confirmando(View v){

        usuarios.add(u);
        for(Usuario usuario : usuarios){
            Log.i("Usuario" , usuario.getNome());
            Log.i("Usuario" , usuario.getEmail());
            Log.i("Usuario" , usuario.getSexo());
        }

        Intent proximo = new Intent(this, CadastrarUsuarioActivity.class);
       /* proximo.addCategory("Intent.category.ListarUsuario");
        proximo.putExtra(UsuarioCadastrado.EXTRA_NOME_USUARIO, this.saudacaoTextView.getText().toString()  );
        proximo.putExtra(UsuarioCadastrado.EXTRA_EMAIL, this.confirmEmail.getText().toString());
        */


        onDestroy();
        startActivity(proximo);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
