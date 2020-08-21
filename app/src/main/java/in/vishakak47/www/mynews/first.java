package in.vishakak47.www.mynews;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.net.NetworkInfo.*;

public class first extends AppCompatActivity {

    ListView lv;
    String title,image,link;
    int x=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        lv=findViewById(R.id.lv);
        int x=getIntent().getIntExtra("trend",0);
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() ==  NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() ==  NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            if(x==1)
            {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvnews-trending-news").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();}
            }
            else if(x==2) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvnews-world-news").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==3) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvsports-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==4) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvprofit-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==5) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvmovies-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==6) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvcooks-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==7) {
                try {
                    new processInBackground("https://feeds.feedburner.com/ndtvnews-india-news").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==8) {
                try {
                    new processInBackground("https://feeds.feedburner.com/gadgets360-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if(x==9) {
                try {
                    new processInBackground("https://feeds.feedburner.com/carandbike-latest").execute();//only add this then it will show add try and catch in made a constructer passing url has an argument so that i can use multiple feeds
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

        }
        else
        {
            Toast.makeText(this, "Please connect to internet", Toast.LENGTH_LONG).show();

        }





    }
    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream(); //used to setup a connection and input stream is used to get the url connection established
        } catch (IOException e) {
            return null;
        }
    }
    public class processInBackground extends AsyncTask<Integer,Void,String>//here the last argument is the type u wnt to return in on postexecute and the first argument is input to onbackground

    {
        URL url;
        public processInBackground(String urx) throws MalformedURLException {
            url = new URL(urx);
        }
        Exception ex = null;
        ProgressDialog progressDialog = new ProgressDialog(first.this);
        ArrayList<Articles> articles=new ArrayList<>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Busing Loading please wait.......");
            progressDialog.show();
        }


        @Override
        protected String doInBackground(Integer... integers) {
            try {
                //articles.clear();
                // Articles article=new Articles();
                //here the file is xml in the form of rss feed
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//used to return data from the xml document and used to create xml pull parser
                factory.setNamespaceAware(false);//to provide support xml namespace or not
                XmlPullParser xpp = factory.newPullParser();//xpp here used to access through the rss file
                xpp.setInput(getInputStream(url), "UTF_8");
                boolean insideitem = false; // used to know whether we are inside the item tag
                int eventType = xpp.getEventType();//return type of xml tag and tells where we are in the rss file
                while (eventType != XmlPullParser.END_DOCUMENT)//because we want to read until the end of the document
                {
                    if (eventType == XmlPullParser.START_TAG)//because true if we reach a starting tag
                    {
                        if (xpp.getName().equalsIgnoreCase("item"))//getName returns the name of  the tag and here we are whether the tag is item because data is present inside the item tag
                        {
                            insideitem = true;//by setting this to true we are denoting that we are inside the item tag
                        } else if (xpp.getName().equalsIgnoreCase("title")) {
                            if (insideitem)//because we are setting true when we are inside the item tag because we have to acces the title tag inside the item has title tag are also present outside the item
                            {
                                title=xpp.nextText();
                                //article.setTitle(xpp.nextText());//it returns the text inside a particular here inside title tag
                            }
                        } else if (xpp.getName().equalsIgnoreCase("link"))//this is  for link tag because in the app we want to extract link and title
                        {
                            if (insideitem) {
                                link=xpp.nextText();
                            }
                        }
                        else if(xpp.getName().equalsIgnoreCase("StoryImage"))
                        {

                            if (insideitem) {
                                image=xpp.nextText();
                                articles.add(new Articles(title,image,link));

                            }
                        }

                    } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item"))//if the tag is item and we reach the end of the item tag (i.e closing tag) we want to set inside item has false
                    {
                        insideitem = false;
                        //  articles.add(article);

                    }
                    eventType = xpp.next();//used to increment and go to the next tag (like a variable increments to go through the data)
                }
            } catch (MalformedURLException e) {
                ex = e;
            } catch (XmlPullParserException e) {
                ex = e;
            } catch (IOException e) {
                ex = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            lv.setAdapter(new CustomAdapter(first.this,articles));
        }
    }
}
