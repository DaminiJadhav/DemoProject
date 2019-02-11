package com.example.syntagi.demoproject;

import android.os.AsyncTask;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Xml_Doc_parse extends AppCompatActivity {
PlaceholderFragment taskFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml__doc_parse);
        if (savedInstanceState==null)
        {
            //First Time
            taskFragment=new PlaceholderFragment();
            getSupportFragmentManager().beginTransaction().add(taskFragment,"MyFragment").commit();
        }else
        {
            taskFragment= (PlaceholderFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        }
    }
    public static class PlaceholderFragment extends Fragment
    {
        TechCrunchTask downloadTask;
        public PlaceholderFragment()
        {

        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);
        }
        public void startTask()
        {
            downloadTask=new TechCrunchTask();
            downloadTask.execute();
        }
    }



    public static class TechCrunchTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {
           String downloadURL="http://feeds.feedburner.com/techcrunch/android?format=xml";
           try
           {
               URL url=new URL(downloadURL);
               HttpURLConnection connection= (HttpURLConnection) url.openConnection();
               InputStream inputStream=connection.getInputStream();
               processXML(inputStream);
           }
           catch (Exception e)
           {

               L.m(e +"rss");

           }
           return null;
        }
        public void processXML(InputStream inputStream) throws Exception
        {
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument =documentBuilder.parse(inputStream);
            Element rootelement =xmlDocument.getDocumentElement();
            L.m("" + rootelement.getTagName());
            NodeList nodeList=rootelement.getElementsByTagName("item");
            Node currentItem=null;
            for (int i=0;i<nodeList.getLength();i++)
            {
                currentItem=nodeList.item(i);
                L.m("" +currentItem.getNodeName());
            }
        }
    }
}
