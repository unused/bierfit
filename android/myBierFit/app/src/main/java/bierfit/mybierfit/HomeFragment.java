package bierfit.mybierfit;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        return v;
    }
}
