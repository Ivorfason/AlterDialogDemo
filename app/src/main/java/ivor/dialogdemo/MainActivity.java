package ivor.dialogdemo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener{

    public final static String ALERT_DIALOG_TAG = "ALERT_DIALOG_TAG";
    @Bind(R.id.ivor1_btn)
    Button ivor1Btn;
    @Bind(R.id.ivor2_btn)
    Button ivor2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.ivor1Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivor1_btn:
                AlterDialogFragment alterDialogFragment = AlterDialogFragment.newInstance("Ivor", "Handsome Boy!");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                alterDialogFragment.show(fragmentTransaction, ALERT_DIALOG_TAG);
                break;
            default:
                break;
        }
    }

    public void onDialogBack(String tag, boolean cancelled, CharSequence message) {
        if(cancelled) {
            String s = tag + " Was Cancelled By Ivor";
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
        this.ivor2Btn.setText("Good!");
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
