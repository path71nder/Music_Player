package com.example.musicplayer;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Lagu> daftarLagu;
    private ListView laguView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        laguView = (ListView)findViewById(R.id.daftar_lagu);
        daftarLagu = new ArrayList<Lagu>();
        getSongList();
    }

    public void getSongList(){
        //mengambil info lagu
        ContentResolver laguResolver = getContentResolver();
        Uri laguUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor laguCursor = laguResolver.query(laguUri, null, null, null,null);
        if (laguCursor != null && laguCursor.moveToFirst()){
            int judulColumn = laguCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idColumn = laguCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artisColumn = laguCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            while (laguCursor.moveToNext()){
                long thisId = laguCursor.getLong(idColumn);
                String thisJudul = laguCursor.getString(judulColumn);
                String thisArtis = laguCursor.getString(artisColumn);
                daftarLagu.add(new Lagu(thisId, thisJudul, thisArtis));
            }
        }
    }
}
