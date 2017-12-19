package com.example.anaval.fragmentodinamico;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmento extends Fragment {
    int mNum;
    View tv;
    static Fragmento newInstance(int number) {
        Fragmento f = new Fragmento();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = null;
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragment_fragmento, container, false);
             v.findViewById(R.id.text);            }
        else{
            v = inflater.inflate(R.layout.fragmento_2, container, false);
            v.findViewById(R.id.text2);
        }

        ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
        return v;
    }
}

