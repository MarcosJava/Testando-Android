package br.com.mrcsfelipe.testando;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mrcsfelipe.testando.entity.Usuario;

/**
 * Created by u6448938 on 02/07/2015.
 */
public class ListarUsuario extends ListActivity implements AdapterView.OnItemClickListener {


    private List<Map<String, Object>> viagens = new ArrayList<>();


    public List<Map<String, Object>> listarUsuarioPorEmail(){

        Integer size = CadastrarUsuarioActivity.usuarios.size();
        Log.i("SIZE", size.toString());


        Map<String, Object> item = new HashMap<String, Object>();


        for (Usuario u : CadastrarUsuarioActivity.usuarios){
            item = new HashMap<String, Object>();
            if(u.getSexo().equals("F")) {
                item.put("imagem", R.drawable.img_female);
            }else {
                item.put("imagem", R.drawable.img_male);
            }
            item.put("nome", u.getNome());
            item.put("email",u.getEmail());
            viagens.add(item);
        }



        return viagens;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.listar_usuarios);

        String[] de = {"imagem", "nome", "email"};
        int[] para = {R.id.imagem, R.id.nome, R.id.email};


        SimpleAdapter adapter = new SimpleAdapter(this,listarUsuarioPorEmail(), R.layout.trazer_usuarios, de, para );

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);



/*
        String[] values = new String[]{"oi","duas"};
        for(Usuario u : UsuarioCadastrado.usuarios){
            Log.i("usuario", u.getEmail());
            values[values.length -1] = u.getEmail();
        }

        setListAdapter(new ArrayAdapter<String>(this,
                                                 R.layout.listar_usuarios,
                                                 R.id.label,
                                                 values));

        ListView listView = getListView();
        listView.setOnItemClickListener(this);

        /*
        Bundle dados = getIntent().getExtras();

        String nome = (String) dados.get(UsuarioCadastrado.EXTRA_NOME_USUARIO);
        String email = (String) dados.get(UsuarioCadastrado.EXTRA_EMAIL);


        Intent intent = getIntent();
        String nome = intent.getStringExtra(UsuarioCadastrado.EXTRA_NOME_USUARIO);
        String email = intent.getStringExtra(UsuarioCadastrado.EXTRA_EMAIL);
        if(nome == null || nome.equals("")){

        } else if(email == null || email.equals("")){

        }else{
            usuario = new Usuario(nome,email);


            Log.i("Obj", usuario.toString());
        }
        */

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = viagens.get(position);
        String nome = (String) map.get("nome");
        String mensagem = "Usuario Selecionado: "+ nome;
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(this, GastoListActivity.class));


    }
}
