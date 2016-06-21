package bierfit.mybierfit;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

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

        ///assets/application-0135db13e85cd5eaa3f3915be2dacfd9c89cac5f0f4b9bf6ca4d70818b2b2f67.js

        WebView myWebView = (WebView)v.findViewById(R.id.webview_percentage);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                injectScriptFile(view, "/assets/application-0135db13e85cd5eaa3f3915be2dacfd9c89cac5f0f4b9bf6ca4d70818b2b2f67.js"); // see below ...

                // test if the script was loaded
                view.loadUrl("javascript:setTimeout(test(), 500)");
            }

            private void injectScriptFile(WebView view, String scriptFile) {
                InputStream input;
                try {
                    input = getActivity().getAssets().open(scriptFile);
                    byte[] buffer = new byte[input.available()];
                    input.read(buffer);
                    input.close();

                    // String-ify the script byte-array using BASE64 encoding !!!
                    String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
                    view.loadUrl("javascript:(function() {" +
                            "var parent = document.getElementsByTagName('head').item(0);" +
                            "var script = document.createElement('script');" +
                            "script.type = 'text/javascript';" +
                            // Tell the browser to BASE64-decode the string into your script !!!
                            "script.innerHTML = window.atob('" + encoded + "');" +
                            "parent.appendChild(script)" +
                            "})()");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        myWebView.loadUrl("https://bierfit.herokuapp.com/users/admin");


//        profile.addJavascriptInterface(new WebAppInterface(this), "Android");

//        profile.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                // Activities and WebViews measure progress with different scales.
//                // The progress meter will automatically disappear when we reach 100%
//                getActivity().setProgress(progress * 1000);
//            }
//        });
//        profile.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(getActivity(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
//            }
//        });

//        profile.loadUrl("https://bierfit.herokuapp.com/assets/application-0135db13e85cd5eaa3f3915be2dacfd9c89cac5f0f4b9bf6ca4d70818b2b2f67.js");

        //myWebView.loadUrl("javascript:https://bierfit.herokuapp.com/assets/application-0135db13e85cd5eaa3f3915be2dacfd9c89cac5f0f4b9bf6ca4d70818b2b2f67.js");
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



    private void injectScriptFile(WebView view, String scriptFile) {
        InputStream input;
        try {
            input = getActivity().getAssets().open(scriptFile);
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();

            // String-ify the script byte-array using BASE64 encoding !!!
            String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
            view.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var script = document.createElement('script');" +
                    "script.type = 'text/javascript';" +
                    // Tell the browser to BASE64-decode the string into your script !!!
                    "script.innerHTML = window.atob('" + encoded + "');" +
                    "parent.appendChild(script)" +
                    "})()");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
