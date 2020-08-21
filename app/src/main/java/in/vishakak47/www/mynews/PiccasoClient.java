package in.vishakak47.www.mynews;


import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PiccasoClient {
    public  static  void downloadImage(Context c, String imageUrl, ImageView img)
    {
        if(imageUrl!=null && imageUrl.length()>0)
        {
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.paceholder).into(img);//placeholder is used to display a image before the actual image loads
        }
        else
        {
            Picasso.with(c).load(R.drawable.paceholder).into(img);
        }
    }
}
