package dk.easj.anbo.swipegesture;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final String TAG = "GESTURES";
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(this, this);
       // getWindow().setExitTransition(new Explode());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Log.d(TAG, "onTuch: " + event);
        // boolean eventHandlingFinished = true;
        //return eventHandlingFinished;
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //Toast.makeText(this, "onShowPress", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSingleTapUp");
        return true; // done
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //Toast.makeText(this, "onScroll", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //Toast.makeText(this, "onLongPress", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //Toast.makeText(this, "onFling", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onFling " + e1.toString() + "::::" + e2.toString());

        boolean leftSwipe = e1.getX() > e2.getX();
        Log.d(TAG, "onFling left: " + leftSwipe);
        if (leftSwipe) {
            Intent intent = new Intent(this, AnotherActivity.class);
            startActivity(intent);
            //ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
            //Bundle options = activityOptionsCompat.toBundle();
            //startActivity(intent, options);

        }
        return true; // done
    }

    public void buttonClicked(View view) {
        Log.d(TAG, "button clicked");
    }
}

