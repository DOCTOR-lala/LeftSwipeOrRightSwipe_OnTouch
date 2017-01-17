package com.example.alienware.leftswipeorrightswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float init_x;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.demo);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                init_x = event.getX();
            case MotionEvent.ACTION_MOVE:
                float diff_x = init_x - event.getX() ;
                int pos = diff_x < 0? 1 : diff_x==0? 0 : -1;
                switch (pos){
                    case -1:
                        textView.setText(R.string.left);
                        return true;
                    case 0:
                        textView.setText(R.string.no_change);
                        return true;
                    case 1:
                        textView.setText(R.string.right);
                        return true;

                }
        }
        return true;
    }
}
