package com.example.shusmoy.arong_salesman;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    int f = 0;

    int o = 0;
    String item;
    //Striniteme;
    String m;
    String cashmnemo;
    String[]  orders= new String[1000];
    database sch = new database(this);
    dataorder so= new dataorder(this);
    SQLiteDatabase sqdb;
    SQLiteDatabase sodb;
    String typ;

    String[] cmo = new String[1000];
    String[] oitem = new String[1000];
    String[] otype = new String[1000];
    int[] oamount= new int[1000];
    int[] oprice= new int[1000];
    int i = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sqdb = sch.getWritableDatabase();
        sodb= so.getWritableDatabase();

        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void Continue(View view) {
        sch.onUpgrade(sqdb,1,1);
        so.onUpgrade(sodb,1,1);
        sqdb= sch.getWritableDatabase();
        String iteme = "গুঁড়ো দুধ";
        String type = "৫০০ gm(ফুলক্রিম)";
        sch.addprice(sqdb,iteme,type,500);
        type = "৪০০ gm(ফুলক্রিম)";
        sch.addprice(sqdb,iteme,type,400);
        type = "৭৫ gm(ফুলক্রিম)";
        sch.addprice(sqdb,iteme,type,110);
        type = "৫০ gm(ফুলক্রিম)";
        sch.addprice(sqdb,iteme,type,80);
        type = "২৫ gm(ফুলক্রিম)";
        sch.addprice(sqdb,iteme,type,55);
        type = "৪০০ gm(লো ফ্যাট)";
        sch.addprice(sqdb,iteme,type,350);

        iteme = "ঘি";
        type = "৯০০ gm";
        sch.addprice(sqdb,iteme,type,1000);
        type = "৪০০ gm";
        sch.addprice(sqdb,iteme,type,550);
        type = "২০০ gm";
        sch.addprice(sqdb,iteme,type,250);
        type = "১০০ gm";
        sch.addprice(sqdb,iteme,type,150);
        type = "৬০ gm";
        sch.addprice(sqdb,iteme,type,80);
        type = "৩০ gm";
        sch.addprice(sqdb,iteme,type,45);
        type = "১৫ gm";
        sch.addprice(sqdb,iteme,type,25);


        iteme = "ইউ এইচ টি";
        type = "দুধ (ফিনো প্যাক) ১/২ লিটার";
        sch.addprice(sqdb,iteme,type,35);
        type = "চকলেট ড্রিংক ২৫০ মিলি";
        sch.addprice(sqdb,iteme,type,20);
        type = "স্ট্রবেরি ইয়োগার্ট ড্রিংক ২৫০ মিলি";
        sch.addprice(sqdb,iteme,type,45);
        type = "তেঁতুল ড্রিংক ২৫০ মিলি";
        sch.addprice(sqdb,iteme,type,35);



        System.out.println("written");
        setContentView(R.layout.sales_man_home);
    }

    public void ghee(View view) {
        item="ঘি" ;

        setContentView(R.layout.ghee);
    }

    public void salesorder(View view) {
        item="অর্ডার";

        setContentView(R.layout.products);
    }

    public void milk(View view) {
        item="গুঁড়ো দুধ";

        setContentView(R.layout.milk);
    }


    public void uht(View view) {
        item="ইউ এইচ টি";

        setContentView(R.layout.uht);
    }

    public void gorder(View view) {
        int p=0;
        EditText one= (EditText) findViewById(R.id.lit);
        Editable e= one.getText();

        String type;
        if(!TextUtils.isEmpty(e))
        {
            int n= Integer.parseInt(String.valueOf(e));

            TextView t=(TextView)findViewById(R.id.litr);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko=""+n;
            ((EditText) findViewById(R.id.lit)).setText(ko,TextView.BufferType.EDITABLE);



        }
        EditText one1= (EditText) findViewById(R.id.ftrp);
        Editable e1= one1.getText();

        if(!TextUtils.isEmpty(e1))
        {
            int n= Integer.parseInt(String.valueOf(e1));

            TextView t=(TextView)findViewById(R.id.ftrm);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko =""+ n;
            one1.setText(ko);


        }

        EditText one2= (EditText) findViewById(R.id.tgh);
        Editable e2= one2.getText();
        if(!TextUtils.isEmpty(e2))
        {
            int n= Integer.parseInt(String.valueOf(e2));

            TextView t=(TextView)findViewById(R.id.tftm);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;

            one2.setText(ko);


        }

        EditText one3= (EditText) findViewById(R.id.tndr);
        Editable e3= one3.getText();
        if(!TextUtils.isEmpty(e3))
        {
            int n= Integer.parseInt(String.valueOf(e3));

            TextView t=(TextView)findViewById(R.id.tnd);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko =""+n;
            one3.setText(ko);


        }

        EditText one4= (EditText) findViewById(R.id.lftr);
        Editable e4= one4.getText();
        if(!TextUtils.isEmpty(e4))
        {
            int n= Integer.parseInt(String.valueOf(e4));

            TextView t=(TextView)findViewById(R.id.lft);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;
            one4.setText(ko);


        }

        EditText one5= (EditText) findViewById(R.id.chp);
        Editable e5= one.getText();
        if(!TextUtils.isEmpty(e5))
        {
            int n= Integer.parseInt(String.valueOf(e5));

            TextView t=(TextView)findViewById(R.id.ch);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;
            one5.setText(ko);


        }

        EditText one6= (EditText) findViewById(R.id.mnp);
        Editable e6= one6.getText();
        if(!TextUtils.isEmpty(e6))
        {
            int n= Integer.parseInt(String.valueOf(e6));

            TextView t=(TextView)findViewById(R.id.mn);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;


            String ko = ""+n;
            one6.setText(ko);

        }




        //Cursor c = sqdb.rawQuery("select * from price", null);

        setContentView(R.layout.products);

    }



    public void morder(View view) {
        int p=0;
        EditText one= (EditText) findViewById(R.id.lit);
        Editable e= one.getText();

        String type;
        if(!TextUtils.isEmpty(e))
        {
            int n= Integer.parseInt(String.valueOf(e));

            TextView t=(TextView)findViewById(R.id.litr);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko=""+n;
            ((EditText) findViewById(R.id.lit)).setText(ko,TextView.BufferType.EDITABLE);



        }
        EditText one1= (EditText) findViewById(R.id.ftrp);
        Editable e1= one1.getText();

        if(!TextUtils.isEmpty(e1))
        {
            int n= Integer.parseInt(String.valueOf(e1));

            TextView t=(TextView)findViewById(R.id.ftrm);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko =""+ n;
            one1.setText(ko);


        }

        EditText one2= (EditText) findViewById(R.id.tgh);
        Editable e2= one2.getText();
        if(!TextUtils.isEmpty(e2))
        {
            int n= Integer.parseInt(String.valueOf(e2));

            TextView t=(TextView)findViewById(R.id.tftm);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;

            one2.setText(ko);


        }

        EditText one3= (EditText) findViewById(R.id.tndr);
        Editable e3= one3.getText();
        if(!TextUtils.isEmpty(e3))
        {
            int n= Integer.parseInt(String.valueOf(e3));

            TextView t=(TextView)findViewById(R.id.tnd);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko =""+n;
            one3.setText(ko);


        }

        EditText one4= (EditText) findViewById(R.id.lftr);
        Editable e4= one4.getText();
        if(!TextUtils.isEmpty(e4))
        {
            int n= Integer.parseInt(String.valueOf(e4));

            TextView t=(TextView)findViewById(R.id.lft);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);
                ;
            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;
            one4.setText(ko);


        }

        EditText one5= (EditText) findViewById(R.id.chp);
        Editable e5= one.getText();
        if(!TextUtils.isEmpty(e5))
        {
            int n= Integer.parseInt(String.valueOf(e5));

            TextView t=(TextView)findViewById(R.id.ch);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;

            String ko = ""+n;
            one5.setText(ko);


        }

        //Cursor c = sqdb.rawQuery("select * from price", null);

        setContentView(R.layout.products);
    }


    public void uorder(View view) {
        int p=0;
        EditText one= (EditText) findViewById(R.id.lit10);
        String e= one.getText().toString();

        String type;
        if(!TextUtils.isEmpty(e))
        {
            int n= Integer.parseInt(String.valueOf(e));

            TextView t=(TextView)findViewById(R.id.litr1);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type + " X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;
            String ko=""+n;
            ((EditText) findViewById(R.id.lit10)).setText(ko,TextView.BufferType.EDITABLE);


        }
        EditText one1= (EditText) findViewById(R.id.lit20);
        String e1= one1.getText().toString();

        if(!TextUtils.isEmpty(e1))
        {
            int n= Integer.parseInt((String.valueOf(e1)));
            TextView t=(TextView)findViewById(R.id.litr2);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type +"("+p+"টাকা)"+" X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;
            String ko=""+n;
            one1.setText(ko);


        }

        EditText one2= (EditText) findViewById(R.id.lit30);
        String e2= one2.getText().toString();
        if(!TextUtils.isEmpty(e2))

        {
            int n= Integer.parseInt((String.valueOf(e2)));
            TextView t=(TextView)findViewById(R.id.litr3);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type +"("+p+"টাকা)"+" X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;
            String ko=""+n;
            one2.setText(ko);


        }
        EditText one3= (EditText) findViewById(R.id.lit40);
        String e3= one3.getText().toString();

        if(!TextUtils.isEmpty(e3))
        {
            int n= Integer.parseInt((String.valueOf(e3)));

            TextView t=(TextView)findViewById(R.id.litr4);
            type= (String) t.getText();
            oitem[i]=item;
            otype[i]=type;
            oamount[i]=n;
            Cursor c =sqdb.rawQuery("SELECT Price from " + "Price" + " WHERE" + " Item " + "= ? And " + "Type " + "= ?", new String[] { item,type});
            if(c.moveToNext()) {
                int colid = c.getColumnIndex("Price");
                p= c.getInt(colid);
                System.out.println("Price "+colid+ " "+ p);

            }
            int sum = p * n;
            oprice[i]=sum;
            typ = "" + item + " " + type +"("+p+"টাকা)"+" X " + n + " = " + sum + " \n";

            cmo[i] = typ;
            i++;
            String ko=""+n;
            one3.setText(ko);


        }


        //Cursor c = sqdb.rawQuery("select * from price", null);

        setContentView(R.layout.products);
    }

    public  void  ret_home(View view){

        setContentView(R.layout.sales_man_home);
    }

    public  void  ret_prod(View view){

        setContentView(R.layout.products);
    }


    public  void  add_shop(View view){

        setContentView(R.layout.new_shop);
    }



    public void memo(View view) {
        cashmnemo = "";
        setContentView(R.layout.cashmemo);
        TextView mon = (TextView) findViewById(R.id.mem);
        for (int j = 0; j < i; j++)
            cashmnemo = cashmnemo + (j + 1) + ". " + cmo[j];
        mon.setText(cashmnemo);
        int sum=0;
        for(int j=0;j<i;j++)
            sum=sum+oprice[j];
        TextView txt=(TextView) findViewById(R.id.txt);
        String m= "মোট বিল = "+ sum+ " টাকা";
        txt.setText(m);
    }

    public void done(View view) {

        setContentView(R.layout.products);
    }

    public void rdone(View view) {
        EditText op = (EditText) findViewById(R.id.ono);
        Editable p = op.getText();
        int s = Integer.parseInt(String.valueOf(p));
        oitem[s-1]=oitem[i-1];
        otype[s-1]=otype[i-1];
        oamount[s-1]=oamount[i-1];
        oprice[s-1]=oprice[i-1];
        cmo[s - 1] = cmo[i - 1];
        i--;
        memo(view);
    }

    public void don(View view) {
        setContentView(R.layout.products);
    }

    public void rmov(View view) {
        EditText rno= (EditText) findViewById(R.id.kl);
        Editable r= rno.getText();
        int x= Integer.parseInt(String.valueOf(r));
        if(x!=0)
        {
            int s= Integer.parseInt(String.valueOf(r));
            oitem[s-1]=oitem[i-1];
            otype[s-1]=otype[i-1];
            oamount[s-1]=oamount[i-1];
            oprice[s-1]=oprice[i-1];
            cmo[s - 1] = cmo[i - 1];
            i--;
        }
        memo(view);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void giveorder(View view) {
        for(int j=0;j<i;j++)
        {
            so.addorder(sodb,oitem[j],otype[j],oamount[j],oprice[j]);
        }
        Cursor c = sodb.rawQuery("select * from ArongOrder", null);
        while(c.moveToNext())
        {
            int col= c.getColumnIndex("Type");
            String s= c.getString(col);
            System.out.println(s);
            col= c.getColumnIndex("Price");
            System.out.println(c.getInt(col));
        }
     
    }


    public void memoc(View view) {
        cashmnemo = "";
        setContentView(R.layout.memo);
        TextView mon = (TextView) findViewById(R.id.cm);
        for (int j = 0; j < i; j++)
            cashmnemo = cashmnemo + (j + 1) + ". " + cmo[j];
        mon.setText(cashmnemo);
        int sum=0;
        for(int j=0;j<i;j++)
            sum=sum+oprice[j];
        TextView txt=(TextView) findViewById(R.id.bi);
        m= " মোট বিল= "+ sum+ " টাকা";
        txt.setText(m);
    }

    public void rmovec(View view) {
        EditText rno= (EditText) findViewById(R.id.kl);
        Editable r= rno.getText();
        int x= Integer.parseInt(String.valueOf(r));
        if(x!=0)
        {
            int s= Integer.parseInt(String.valueOf(r));
            oitem[s-1]=oitem[i-1];
            otype[s-1]=otype[i-1];
            oamount[s-1]=oamount[i-1];
            oprice[s-1]=oprice[i-1];
            cmo[s - 1] = cmo[i - 1];
            i--;
        }
        memoc(view);
    }

    public void confirmorder(View view) {
        for(int j=0;j<i;j++)
        {
            so.addorder(sodb,oitem[j],otype[j],oamount[j],oprice[j]);
        }
        Cursor c = sodb.rawQuery("select * from ArongOrder", null);
        while(c.moveToNext())
        {
            int col= c.getColumnIndex("Type");
            String s= c.getString(col);
            System.out.println(s);
            col= c.getColumnIndex("Price");
            System.out.println(c.getInt(col));
        }
        setContentView(R.layout.products);
        orders[o]=cashmnemo+"\n"+m+"\n";
        System.out.println(orders[f]);
        o++;
        i=0;
    }
    public void orders(View view) {
        setContentView(R.layout.orders);
        TextView e= (TextView) findViewById(R.id.ordr);
        String c="";
        for(int f=0;f<o;f++)
        {
            System.out.println(orders[f]);
            c=c+"অর্ডার নং "+ (f+1)+"\n"+orders[f];
        }
        e.setText(c);
    }

}
