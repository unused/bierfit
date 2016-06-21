package bierfit.mybierfit;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kosha on 21/06/2016.
 */
public class httpHandler extends AsyncTask<Void, Void, Boolean> {

    HttpURLConnection urlc;
    int result = -1;
    HomeFragment homeFragment;
    String fun = "";

    public httpHandler(HomeFragment homeFragment_) {
        this.homeFragment = homeFragment_;
    }

    public void signUp() {
        this.fun = "signup";
        execute();
    }

    public void logIn() {
        this.fun = "login";
        execute();
    }


    @Override
    protected Boolean doInBackground(Void... arg0) {
        try {
            urlc = (HttpURLConnection) (new URL("https://bierfit.herokuapp.com/users/admin.json").openConnection());
            //urlc.setRequestProperty("User-Agent", "Test");
            //urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(500);
            urlc.connect();
            Log.e("hugo", "response: " + urlc.getResponseCode());

            return urlc.getResponseCode() == 200 ? true : false;

        } catch (IOException e) {
        }

        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        try {
            this.result = urlc.getResponseCode();
        } catch (Exception e) {
            this.result = -2;
        }

        if(fun.equals("login"))
            homeFragment.loginUser();
        else
            homeFragment.signUser();
    }

}