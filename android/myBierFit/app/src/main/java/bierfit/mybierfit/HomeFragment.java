package bierfit.mybierfit;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by kosha on 18/06/2016.
 */
public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);

        TextView description = (TextView) v.findViewById(R.id.description);
        description.setText(Html.fromHtml("<body>" +
                "<h1>Bierfit - Fitness Tracker</h1>\n" +
                "\n" +
                "  <div class=\"jumbotron row\">\n" +
                "\n" +
                "  <div class=\"col-md-6 text-justify\">\n" +
                "    <h2>Noroc!</h2>\n" +
                "    <p>\n" +
                "      We at Bierfit believe in people, science, technology, sometimes in\n" +
                "      coincidences but most and above all, in beer.\n" +
                "    </p>\n" +
                "    <p>\n" +
                "      With Beerfit you have the excellent tool at your service to see your\n" +
                "      personal, as well as your friends activities, earn achievments and make a\n" +
                "      step into the future. Simply sign up to Bierfit, connect your MeiDeckel and\n" +
                "      start drinking.\n" +
                "    </p>\n" +
                "       \n" +
                "  </div>\n" +
                "</div>\n" +
                "</body>"));

        if(((MainActivity)getActivity()).isLogedIn()) {
            Toast.makeText(getActivity().getApplicationContext(), "already logged in", Toast.LENGTH_SHORT).show();
            v.findViewById(R.id.frame_reg_layout).setVisibility(View.GONE);
        }

        Button learnmore = (Button) v.findViewById(R.id.button_learnmore);
        learnmore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String url = v.getResources().getString(R.string.github);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


        Button signup = (Button) v.findViewById(R.id.button_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                TextView tvUsername = (TextView)getActivity().findViewById(R.id.login);
                TextView tvPassword = (TextView)getActivity().findViewById(R.id.password);
                boolean success = false;

                if(tvPassword.getText() != null && tvUsername.getText() != null) {
                    //TODO add email
                    success = ((MainActivity) getActivity()).accountHandler.registerUser(
                            tvUsername.getText().toString(),
                            tvPassword.getText().toString()
                    );
                }

                if(success)
                    Toast.makeText(getActivity().getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                Log.e("Register", "" + success);
                            }
        });

        Button login = (Button) v.findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Toast.makeText(getActivity().getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                //TODO check if successful
                TextView tvUsername = (TextView)getActivity().findViewById(R.id.login);
                TextView tvPassword = (TextView)getActivity().findViewById(R.id.password);

                if(((MainActivity) getActivity()).accountHandler.loginUser(
                        tvUsername.getText().toString(), tvPassword.getText().toString())) {

                    ((MainActivity) getActivity()).setLogedIn(true);
                    ((FrameLayout) getActivity().findViewById(R.id.frame_reg_layout)).setVisibility(View.GONE);
                }
            }
        });


        return v;
    }
}
