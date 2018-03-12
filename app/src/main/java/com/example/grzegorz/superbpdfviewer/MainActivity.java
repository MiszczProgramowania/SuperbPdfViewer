package com.example.grzegorz.superbpdfviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;

public class MainActivity extends AppCompatActivity  implements OnErrorListener {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById(R.id.pdfView);
//        String url = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/pdf.pdf";
        pdfView.fromAsset("pdf.pdf")
//                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
//                .onPageChange(onPageChangeListener)
//                .onPageScroll(onPageScrollListener)
                .onError(this)
//                .onPageError(onPageErrorListener)
//                .onRender(onRenderListener)
                .load();
    }

        @Override
        public void onError(Throwable t) {
            Log.e("Cannot load", t.getMessage().toString());
        }
}
