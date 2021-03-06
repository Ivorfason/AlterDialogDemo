package ivor.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Ivor on 2016/2/23.
 */
public class AlterDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    public static AlterDialogFragment newInstance(String title, String message){
        AlterDialogFragment alterDialogFragment = new AlterDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        alterDialogFragment.setArguments(args);
        return alterDialogFragment;
    }

    private String getTitle(){
        return getArguments().getString("title");
    }

    private String getMessage(){
        return getArguments().getString("message");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(getTitle())
                .setMessage(getMessage())
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel", this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        boolean isCancel = false;
        if(which == AlertDialog.BUTTON_NEGATIVE) {
            isCancel = true;
        }
        MainActivity act = (MainActivity) getActivity();
        act.onDialogBack(getTag(), isCancel, "Good Job!");
    }

}