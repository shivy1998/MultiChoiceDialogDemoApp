package lockdown.org.dialogdemoapp3;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button btnDialog;
    String arr[] = {"Java ","Android ","Python ","Machine Learning "};
    ArrayList al = new ArrayList();
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btnDialog=findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Courses Offered");
                ab.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener()
                {
                    public void onClick(DialogInterface dialog, int which, boolean isChecked)
                    {
                        if(isChecked)
                        {
                            al.add(arr[which]);
                        }
                        else
                        {
                            al.remove(arr[which]);
                        }
                    }
                });
                ab.setPositiveButton("Show", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int i)
                    {
                        Toast.makeText(MainActivity.this, "Selected itmes are "+al, Toast.LENGTH_SHORT).show();
                        al.clear();
                    }
                });
                ab.show();
            }
        });
    }
}
