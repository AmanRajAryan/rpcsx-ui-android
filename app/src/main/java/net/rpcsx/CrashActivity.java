package net.rpcsx;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class CrashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        TextView crashTextView = findViewById(R.id.crashTextView);
        String stackTrace = getIntent().getStringExtra("stack_trace");

        if (stackTrace != null) {
            crashTextView.setText(stackTrace);
        } else {
            crashTextView.setText("No stack trace available");
        }

        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(v -> restartApp());
    }

    private void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
