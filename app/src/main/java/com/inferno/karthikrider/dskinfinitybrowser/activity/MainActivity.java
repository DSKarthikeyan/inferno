package com.inferno.karthikrider.dskinfinitybrowser.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.inferno.karthikrider.dskinfinitybrowser.constants.URLMainConstants;
import com.inferno.karthikrider.dskinfinitybrowser.R;

public class MainActivity extends ActionBarActivity {

    private WebView webView;
    private SwipeRefreshLayout swipe;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        assign Objects
        assignObjects();
        WebAction(URLMainConstants.homePageDuckDuckURL);
    }

    public void assignObjects()
    {
        swipe = (SwipeRefreshLayout)findViewById(R.id.swipe);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction(URLMainConstants.homePageDuckDuckURL);
            }
        });
    }

    public void WebAction(String inputURL){

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setAppCacheEnabled(true);
        webView.loadUrl(inputURL);
        webView.getSettings().setJavaScriptEnabled(true);
        swipe.setRefreshing(true);
        webView.setWebViewClient(new WebViewClient(){

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                webView.loadUrl("file:///android_assets/error.html");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        Intent searchIntent = getIntent();
        String query = searchIntent.getStringExtra(SearchManager.QUERY);

        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction()))
        {
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
            String queryURL = URLMainConstants.homePageDuckDuckURL+
                    URLMainConstants.constantFrontSlash +
                    URLMainConstants.constantURLSearchQuery + query;
            Toast.makeText(this, queryURL, Toast.LENGTH_LONG).show();
            WebAction(queryURL);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed(){

        if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
}
