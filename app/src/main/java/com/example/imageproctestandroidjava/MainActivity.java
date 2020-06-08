package com.example.imageproctestandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    /**
     * レイアウトの初期設定
     */
    private void initLayout() {
        Button btnMono = findViewById(R.id.mono);
        btnMono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnMono();
            }
        });

        Button btnReset = findViewById(R.id.reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnReset();
            }
        });
    }

    /**
     * モノクロボタンのクリックイベント
     */
    private void onClickBtnMono() {
        GrayScale gray = new GrayScale();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        Bitmap mutableBitmap = gray.goImageProcessing(bitmap);
        ImageView imageView  = findViewById(R.id.image);
        imageView.setImageBitmap(mutableBitmap.copy(Bitmap.Config.ARGB_8888, false));
    }

    /**
     * リセットボタンのクリックイベント
     */
    private void onClickBtnReset() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
    }
}