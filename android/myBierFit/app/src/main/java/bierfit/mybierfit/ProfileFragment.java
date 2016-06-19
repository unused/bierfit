package bierfit.mybierfit;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kosha on 19/06/2016.
 */
public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment,container,false);

        TextView description = (TextView) v.findViewById(R.id.user_description);
        description.setText(Html.fromHtml("<body>" +
                "<h1>TODO username</h1>\n" +
                "\n" +
                "  <div class=\"jumbotron row\">\n" +
                "\n" +
                "  <div class=\"col-md-6 text-justify\">\n" +
                "    <p>\n" +
                "      At bierfit since about TODO hour(s)\n" +
                "    </p>\n" +
                "  </div>\n" +
                "</div>\n" +
                "</body>"));



        Button bierfit = (Button) v.findViewById(R.id.button_bierfit);
        bierfit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String info = getActivity().getString(R.string.bierfitinfo) + ":\n"+
                        "Representing your total beer consumption in relation to all the other users at Bierfit. " +
                        "The higher the value (in percentage), the closer you are to the top users";
                Snackbar mySnackbar = Snackbar.make(v, info, Snackbar.LENGTH_LONG);
                View sbv = mySnackbar.getView();
                TextView tv = (TextView) sbv.findViewById(android.support.design.R.id.snackbar_text);
                tv.setMaxLines(5);
                mySnackbar.show();

            }
        });

        return v;
    }
}
