package mn.num.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText A;
    EditText B;
    float tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_two_layout);

        button = (Button) findViewById(R.id.btMenu);
        registerForContextMenu(button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Functions");
        menu.add(0, 1, 0, "+");
        menu.add(0, 2, 0, "-");
        menu.add(0, 3, 0, "*");
        menu.add(0, 4, 0, "/");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                this.add(item.getActionView());
                return true;
            case 2:
                this.sub(item.getActionView());
                return true;
            case 3:
                this.mul(item.getActionView());
                return true;
            case 4:
                this.div(item.getActionView());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void add(View view) {
        A = (EditText) findViewById(R.id.etValueA);
        B = (EditText) findViewById(R.id.etValueB);
        tmp = Float.parseFloat(A.getText().toString()) + Float.parseFloat(B.getText().toString());
        EditText t = (EditText)findViewById(R.id.etResult);
        t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
        Log.i("Амжилттай ", A.getText().toString() + " + " + B.getText().toString() + " үйлдэл хийгдлээ!");
        System.out.println("Амжилттай" + A.getText().toString() + " + " + B.getText().toString() + " үйлдэл хийгдлээ!");
    }

    public void sub(View view) {
        A = (EditText) findViewById(R.id.etValueA);
        B = (EditText) findViewById(R.id.etValueB);
        tmp = Float.parseFloat(A.getText().toString()) - Float.parseFloat(B.getText().toString());
        EditText t = (EditText)findViewById(R.id.etResult);
        t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
        Log.i("Амжилттай ", A.getText().toString() + " - " + B.getText().toString() + " үйлдэл хийгдлээ!");
    }

    public void mul(View view) {
        A = (EditText) findViewById(R.id.etValueA);
        B = (EditText) findViewById(R.id.etValueB);
        tmp = Float.parseFloat(A.getText().toString()) * Float.parseFloat(B.getText().toString());
        EditText t = (EditText)findViewById(R.id.etResult);
        t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
        Log.i("Амжилттай ", A.getText().toString() + " * " + B.getText().toString() + " үйлдэл хийгдлээ!");
    }

    public void div(View view) {
        A = (EditText) findViewById(R.id.etValueA);
        B = (EditText) findViewById(R.id.etValueB);
        tmp = Float.parseFloat(A.getText().toString()) / Float.parseFloat(B.getText().toString());
        EditText t = (EditText)findViewById(R.id.etResult);
        t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
        Log.i("Амжилттай ", A.getText().toString() + " / " + B.getText().toString() + " үйлдэл хийгдлээ!");
    }
}