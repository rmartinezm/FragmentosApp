package com.programacion.robertomtz.fragmentosapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    public final String TIMELINE_JSON = getTimelineJson();
    public static Timeline timeline;
    public final String NEGOCIOS_JSON = getNegociosJson();
    public static BusinessData negocios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.main_progressBar);;

        AsyncTaskFragments atf = new AsyncTaskFragments();
        atf.execute();
    }

    private String getTimelineJson(){
        return "{\n" +
                "  \"status\": 200,\n" +
                "  \"timeline\":[\n" +
                "    {\n" +
                "      \"user\": \"elmontoya7\",\n" +
                "      \"content_title\": \"Hola\",\n" +
                "      \"content_text\": \"Mi primer post! :)\",\n" +
                "      \"image\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Tianna G\",\n" +
                "      \"content_title\": \"\",\n" +
                "      \"content_text\": \"Saludos desde Aca :*\",\n" +
                "      \"image\": \"https://instagram.fmex1-1.fna.fbcdn.net/t51.2885-15/s640x640/sh0.08/e35/17596711_1051709754973052_4041463920869769216_n.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Vicente Guerra\",\n" +
                "      \"content_title\": \"\",\n" +
                "      \"content_text\": \"Está escuchando a Tame Impala: The less I know the better\",\n" +
                "      \"image\": \"https://crashmexico.files.wordpress.com/2015/12/tame-impala-currents.png?w=940\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Jimena Sanchez\",\n" +
                "      \"content_title\": \"Porque gorda...\",\n" +
                "      \"content_text\": \"\",\n" +
                "      \"image\": \"https://instagram.fmex1-1.fna.fbcdn.net/t51.2885-15/s640x640/sh0.08/e35/17596587_281442132284960_8417271799984685056_n.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Ana Cheri\",\n" +
                "      \"content_title\": \"Vida saludable\",\n" +
                "      \"content_text\": \"Sigan a proteina @prothxxx\",\n" +
                "      \"image\": \"https://instagram.fmex1-1.fna.fbcdn.net/t51.2885-15/sh0.08/e35/p640x640/17662319_751412565035209_7396096050655657984_n.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Cesar Cárdenas\",\n" +
                "      \"content_title\": \"Bots!\",\n" +
                "      \"content_text\": \"Curso de bots en UNAM Mobile el próximo jueves 3 de agosto 2017. No faltes!\",\n" +
                "      \"image\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"user\": \"Alexis Texas\",\n" +
                "      \"content_title\": \"\",\n" +
                "      \"content_text\": \"\",\n" +
                "      \"image\": \"https://instagram.fmex1-1.fna.fbcdn.net/t51.2885-15/s640x640/sh0.08/e35/15043790_1039905936114208_5347038785198620672_n.jpg\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private String getNegociosJson(){
        return "{\n" +
                "  \"business_data\": [\n" +
                "    {\n" +
                "      \"name\": \"Tienda CU\",\n" +
                "      \"image\": \"http://cdc-s3-ejece-main.s3.amazonaws.com/uploads/2015/06/unam.jpg\",\n" +
                "      \"lat\": \"19.331949\",\n" +
                "      \"lon\": \"-99.187286\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Estadio Olimpico Universitario\",\n" +
                "      \"image\": \"https://upload.wikimedia.org/wikipedia/commons/5/56/Estadio_olimpico_universitario_unam.jpg\",\n" +
                "      \"lat\": \"19.331260\",\n" +
                "      \"lon\": \"-99.192318\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Hooters Oasis\",\n" +
                "      \"image\": \"http://sevilla.abc.es/media/sevilla/2017/02/10/s/hooters-sevilla-restaurante-U10192525028yED--450x253@abc.jpg\",\n" +
                "      \"lat\": \"19.345890\",\n" +
                "      \"lon\": \"-99.179653\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Librería Gandhi\",\n" +
                "      \"image\": \"https://www.gandhi.com.mx/media/stores/foto_suc_puebla.jpg\",\n" +
                "      \"lat\": \"19.347564\",\n" +
                "      \"lon\": \"-99.181949\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Facultad de Ingenieria\",\n" +
                "      \"image\": \"http://www.oferta.unam.mx/plantel/archivos//images-facing1.jpg\",\n" +
                "      \"lat\": \"19.331572\",\n" +
                "      \"lon\": \"-99.184142\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private class AsyncTaskFragments extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {

            Gson gson = new GsonBuilder().create();
            timeline = gson.fromJson(TIMELINE_JSON, Timeline.class);

            gson = new GsonBuilder().create();
            negocios = gson.fromJson(NEGOCIOS_JSON, BusinessData.class);

            if (isCancelled())
                return false;

            return true;
        }

        @Override
        protected void onPostExecute(Boolean b) {
            if (b){
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
            }else
                onCancelled();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(MainActivity.this, "Carga cancelada", Toast.LENGTH_SHORT).show();
            TextView txt = (TextView) findViewById(R.id.main_textView);
            txt.setText("Cancelado.");
            pb.setVisibility(View.INVISIBLE);
        }
    }
}
