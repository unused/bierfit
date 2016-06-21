package bierfit.mybierfit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by kosha on 17/06/2016.
 */
public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);

        WebView content = (WebView)v.findViewById(R.id.webview_content);
        content.getSettings().setJavaScriptEnabled(true);


        return v;
    }
}
