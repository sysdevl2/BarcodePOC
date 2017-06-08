package uk.co.morrisonsplc.sysdevl2.mycameratracker.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.morrisonsplc.sysdevl2.mycameratracker.MainActivity;
import uk.co.morrisonsplc.sysdevl2.mycameratracker.R;

public class CustomListAdapter extends BaseAdapter{
    ArrayList<Saleable> result;
    Context context;

    float historicX = Float.NaN, historicY = Float.NaN;
    static final int DELTA = 50;
    enum Direction {LEFT, RIGHT;}

    private static LayoutInflater inflater=null;

    public CustomListAdapter(MainActivity mainActivity, ArrayList<Saleable> shoppingList) {
        // TODO Auto-generated constructor stub
        result = shoppingList;
        context = mainActivity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tvItemTitle;
        TextView tvItemDescription;
        TextView tvLinePrice;
        ImageView imgIcon;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.row_item, null);

        holder.tvItemTitle = (TextView) rowView.findViewById(R.id.itemTitle);
        holder.tvItemDescription = (TextView) rowView.findViewById(R.id.itemExtra);
        holder.tvLinePrice = (TextView) rowView.findViewById(R.id.rowTotal);

        holder.imgIcon = (ImageView) rowView.findViewById(R.id.itemIcon);

        holder.tvItemTitle.setText(result.get(position).getBarcode());
        holder.tvItemDescription.setText(result.get(position).getDescription());
        holder.tvLinePrice.setText(String.valueOf(result.get(position).getRetailPrice()));

        final SwipeDetector swipeDetector = new SwipeDetector();
        rowView.setOnTouchListener(swipeDetector);

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swipeDetector.swipeDetected()){
                    //Toast.makeText(context, "Swipe " + result.get(position), Toast.LENGTH_LONG).show();
                    //removeListItem(rowView, position);
                }
                else {
                    // TODO Auto-generated method stub
                    Toast.makeText(context, "Clicked " + result.get(position), Toast.LENGTH_LONG).show();
                }
            }
        });

        return rowView;
    }

    protected void removeListItem(View rowView, final int positon) {

        final Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_out_right);
        rowView.startAnimation(animation);

    }

}