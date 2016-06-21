package bierfit.mybierfit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by kosha on 19/06/2016.
 */
public class SettingsFragment extends Fragment {
    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setting_fragment,container,false);

        user = ((MainActivity)getActivity()).getLoggedUser();


        ((EditText) v.findViewById(R.id.login)).setText(user.getUsername());
        ((EditText) v.findViewById(R.id.password)).setText(user.getEncrypted_password());
        ((EditText) v.findViewById(R.id.email_setting)).setText(user.getEmail());


        Button update = (Button) v.findViewById(R.id.button_update);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "update", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).accountHandler.updateUser(
                        user.getUsername(),
                        ((EditText) getActivity().findViewById(R.id.login)).getText().toString(),
                        ((EditText) getActivity().findViewById(R.id.password)).getText().toString(),
                        ((EditText) getActivity().findViewById(R.id.email_setting)).getText().toString());

                ((MainActivity) getActivity()).setLoggedUser(new User(
                        ((EditText) getActivity().findViewById(R.id.login)).getText().toString(),
                        ((EditText) getActivity().findViewById(R.id.email_setting)).getText().toString(),
                        ((EditText) getActivity().findViewById(R.id.password)).getText().toString()));
            }
        });

        return v;
    }
}
