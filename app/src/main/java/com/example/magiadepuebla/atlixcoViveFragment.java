package com.example.magiadepuebla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class atlixcoViveFragment extends Fragment {

    public atlixcoViveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atlixco_vive, container, false);

        WebView youtubeWebView = view.findViewById(R.id.youtube_webview);

        WebSettings webSettings = youtubeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        youtubeWebView.setWebViewClient(new WebViewClient());

        String videoUrl = "https://www.youtube.com/embed/9guabvo20rI";
        youtubeWebView.loadUrl(videoUrl);

        return view;
    }
}