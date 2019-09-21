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
    // temp variables
    Button button;
    EditText A;
    EditText B;
    float tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_two_layout);

        // match menu button
        button = (Button) findViewById(R.id.btMenu);
        // context menu д үүсгэсэн товчоо бүртгэх
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
        try {
            A = (EditText) findViewById(R.id.etValueA);
            B = (EditText) findViewById(R.id.etValueB);

            tmp = Float.parseFloat(A.getText().toString()) + Float.parseFloat(B.getText().toString());
            EditText t = (EditText)findViewById(R.id.etResult);

            t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
            Log.i("Амжилттай ", A.getText().toString() + " + " + B.getText().toString() + " үйлдэл хийгдлээ!");
        } catch (NumberFormatException e) {
            Log.i("App", getString(R.string.empField));
        }
    }

    public void sub(View view) {
        try {
            A = (EditText) findViewById(R.id.etValueA);
            B = (EditText) findViewById(R.id.etValueB);

            tmp = Float.parseFloat(A.getText().toString()) - Float.parseFloat(B.getText().toString());
            EditText t = (EditText)findViewById(R.id.etResult);

            t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
            Log.i("Амжилттай ", A.getText().toString() + " - " + B.getText().toString() + " үйлдэл хийгдлээ!");
        } catch (NumberFormatException e) {
            int app = Log.i("App", getString(R.string.empField));
        }
    }

    public void mul(View view) {
        try {
            A = (EditText) findViewById(R.id.etValueA);
            B = (EditText) findViewById(R.id.etValueB);

            tmp = Float.parseFloat(A.getText().toString()) * Float.parseFloat(B.getText().toString());
            EditText t = (EditText)findViewById(R.id.etResult);

            t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
            Log.i("Амжилттай ", A.getText().toString() + " * " + B.getText().toString() + " үйлдэл хийгдлээ!");
        } catch (NumberFormatException e) {
            Log.i("App", getString(R.string.empField));
        }
    }

//    declare exception then throw, handle from in called function;

    public void div(View view) {
        try {
            A = (EditText) findViewById(R.id.etValueA);
            B = (EditText) findViewById(R.id.etValueB);

            EditText t = (EditText)findViewById(R.id.etResult);
            tmp = Float.parseFloat(A.getText().toString()) / Float.parseFloat(B.getText().toString());

            t.setText(String.valueOf(tmp), TextView.BufferType.EDITABLE);
            if (!B.getText().toString().equals("0"))
                Log.i("Амжилттай ", A.getText().toString() + " / " + B.getText().toString() + " үйлдэл хийгдлээ!");
        } catch (NumberFormatException e) {
            Log.i("App", getString(R.string.empField));
        }
    }
}