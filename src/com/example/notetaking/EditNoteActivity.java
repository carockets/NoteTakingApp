package com.example.notetaking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditNoteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_note);
		EditText text = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_note, menu);
		return true;
	}
	
	/** Save a note in the database
	 * @param theButton
	 */
	public void onClickSave(View theButton) {
		EditText text = (EditText)findViewById(R.id.editText1);
		NotesDatabase db = new NotesDatabase(this);
		
		db.addNote(new Notes(text.getText().toString()));
		finish();
	}
	
	public void onClickBack (View theButton) {
		finish();
	}

}
