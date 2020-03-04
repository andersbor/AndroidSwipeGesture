package dk.easj.anbo.swipegesture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return DoIt(e1, e2);
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                    float distanceY) {
                return DoIt(e1, e2);
            }

            private boolean DoIt(MotionEvent e1, MotionEvent e2) {
                TextView messageView = findViewById(R.id.anotherMessageTextView);
                float horizontalDistance = Math.abs(e1.getX() - e2.getX());
                float verticalDistance = Math.abs(e1.getY() - e2.getY());
                if (horizontalDistance > verticalDistance) {
                    if (e1.getX() < e2.getX()) {
                        messageView.setText("Right");
                    } else {
                        messageView.setText("Left");
                    }
                    boolean leftMovement = e1.getX() < e2.getX();
                    if (leftMovement) {
                        finish();
                    }
                } else {
                    if (e1.getY() < e2.getY()) {
                        messageView.setText("Down");
                    } else {
                        messageView.setText("Up");
                    }
                }

                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
