package in.vishakak47.www.mynews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Articles> articles;

    public CustomAdapter(first c, ArrayList<Articles> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public int getCount() {

        return articles.size();
    }

    @Override
    public Object getItem(int position)
    {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }
        TextView tvtext=convertView.findViewById(R.id.tvtext);
        ImageView ivimage=convertView.findViewById(R.id.ivimage);
        final Articles article= (Articles) this.getItem(position);
        final String title=article.getTitle();
        String image=article.getImageUrl();
        tvtext.setText(title);
        PiccasoClient.downloadImage(c,image,ivimage);

        convertView.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(c, title, Toast.LENGTH_SHORT).show();
                Uri uri=Uri.parse(article.getLink());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);//here action view is used to view a web page
                c.startActivity(intent);
            }
        });

        return convertView;
    }
}

