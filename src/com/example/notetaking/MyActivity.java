package com.example.notetaking;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        NotesDatabase db = new NotesDatabase(this);
        
        List<Notes> notes = db.getAllNotes();
        
        for (Notes n :notes) {
        	final LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        	TextView view = (TextView) inflater.inflate(R.layout.textview,null);
        	view.setText(n.getNote());
        	LinearLayout lLayout = (LinearLayout)findViewById(R.id.textview1);
        	lLayout.addView(view);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
    
    public void addNote (View theButton) {
    	Intent intent = new Intent(this, EditNoteActivity.class);
    	startActivity(intent);
    }
    
}
