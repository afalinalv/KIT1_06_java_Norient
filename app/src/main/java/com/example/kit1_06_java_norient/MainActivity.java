package com.example.kit1_06_java_norient;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends Activity {
public String orient = "никакая ориентация";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public void onResume(){
        super.onResume();
        EditText mNameEditText;
        mNameEditText = findViewById(R.id.editText);
        GridLayout gridLayout = findViewById(R.id.Grid);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            orient= "Портретная ориентация";
            mNameEditText.setText(orient);

            gridLayout.setColumnCount(1);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            orient= "Альбомная ориентация";
            mNameEditText.setText(orient);
            gridLayout.setColumnCount(2);

            GridLayout.LayoutParams params;
            // Меняю layout_columnSpan="2" при альбомной ориетации у edit Text в контейнере
            params = new GridLayout.LayoutParams(mNameEditText.getLayoutParams());
            params.columnSpec = GridLayout.spec(0, 2); // First cell in first column use columnSpan 2.
            mNameEditText.setLayoutParams(params);
            // Внимательно разобрать этот код
        }
        else
            mNameEditText.setText("Квадратная ориентация");


        // put your code here...

    }
   /* @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen Не перехватывает
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }*/
}
