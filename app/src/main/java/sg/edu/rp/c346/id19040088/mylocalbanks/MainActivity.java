package sg.edu.rp.c346.id19040088.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    TextView tvID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvDBS.setText(R.string.dbs);
            tvOCBC.setText(R.string.ocbc);
            tvUOB.setText(R.string.uob);
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(R.string.dbsChinese);
            tvOCBC.setText(R.string.ocbcChinese);
            tvUOB.setText(R.string.uobChinese);
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        tvID = (TextView) v;
    }

    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (tvID == tvDBS) {
            if (id == R.id.bankWeb) {
                String web = getString(R.string.dbsWeb);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(intentWeb);
            } else if (id == R.id.contact) {
                String contact = getString(R.string.dbsContact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
                startActivity(intentCall);
            }
        }
        if (tvID == tvOCBC) {
            if (id == R.id.bankWeb) {
                String web = getString(R.string.ocbcWeb);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(intentWeb);
            } else if (id == R.id.contact) {
                String contact = getString(R.string.ocbcContact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
                startActivity(intentCall);
            }
        }
        if (tvID == tvUOB) {
            if (id == R.id.bankWeb) {
                String web = getString(R.string.uobWeb);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(intentWeb);
            } else if (id == R.id.contact) {
                String contact = getString(R.string.uobWeb);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }
}
