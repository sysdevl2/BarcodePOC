package uk.co.morrisonsplc.sysdevl2.mycameratracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.morrisonsplc.sysdevl2.mycameratracker.barcodereader.barcodetracker.BarcodeCaptureActivity;
import uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist.CustomListAdapter;
import uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist.Item;
import uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist.Saleable;

public class MainActivity extends Activity implements View.OnClickListener {

    // use a compound button so either checkbox or switch widgets work.
    private TextView statusMessage;
    private TextView barcodeDisplayText;
    private ArrayList<Saleable> list = new ArrayList<Saleable>();
    private ListView shoppingList;

    private static final int RC_BARCODE_CAPTURE = 1; //9001;
    private static final String TAG = "BarcodeMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MorrisonsAgenda-Light.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setContentView(R.layout.activity_main);

        shoppingList = (ListView) findViewById(R.id.ShoppingList);

        findViewById(R.id.read_barcode).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

    @Override
    public void onClick(View v) {
        try{
            if (v.getId() == R.id.read_barcode) {
                // launch barcode activity.
                Intent intent = new Intent(this, BarcodeCaptureActivity.class);
                intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
                intent.putExtra(BarcodeCaptureActivity.UseFlash,false);

                startActivityForResult(intent, RC_BARCODE_CAPTURE);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * <p/>
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MorrisonsAgenda-Light.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        if (resultCode == RESULT_OK && requestCode == RC_BARCODE_CAPTURE) {
            String barcodeValue = data.getStringExtra("Barcode");

            list.add(0,new Item(barcodeValue, "Our brand new Freshly Picked range is \ngoing to change your definition of flavour!", 2, 2));

            shoppingList.setAdapter(new CustomListAdapter(this,list));

            shoppingList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    return false;
                }
            });

        }
    }
}
