package hu.ektf.receptapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dalma on 2016.01.20..
 */
public class ReceptAdapter extends ArrayAdapter<Recept> {

    private static final int LAYOUT = R.layout.main_row_layout;
    Context context;

    public ReceptAdapter(Context context, ArrayList<Recept> items) {
        super(context, LAYOUT, items);
        this.context = context;
    }

    static  class ViewHolder{
        ImageView imgv;
        TextView nevv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;
        if (rowView == null) {
            rowView = View.inflate(getContext(), LAYOUT, null);

            viewHolder = new ViewHolder();
            viewHolder.imgv = (ImageView) rowView.findViewById(R.id.imageView);
            viewHolder.nevv = (TextView) rowView.findViewById(R.id.textView);
            rowView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        final Recept item = getItem(position);
        viewHolder.imgv.setImageResource(item.getKepID());
        //holder.imgv.setImageDrawable(R.drawable.turogomboc);
        viewHolder.nevv.setText(item.getNev());
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main2Activity.class);
                intent.putExtra("név", item.getNev());
                intent.putExtra("kép", item.getKepID());
                getContext().startActivity(intent);
            }
        });
        return rowView;
    }
}
