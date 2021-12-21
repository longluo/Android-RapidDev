package com.longluo.android.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longluo.android.R;


public class MasterFragment extends Fragment {

    private Callbacks callbacks;

    public static MasterFragment newInstance() {
        return new MasterFragment();
    }

    public interface Callbacks {
        void onMasterItemClicked(int masterItemId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof Callbacks)) {
            throw new RuntimeException("Context must implement callbacks");
        }

        callbacks = (Callbacks) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        TextView textView1 = (TextView) view.findViewById(R.id.master_item_1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onMasterItemClicked(1);
            }
        });

        TextView textView2 = (TextView) view.findViewById(R.id.master_item_2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onMasterItemClicked(2);
            }
        });

        TextView textView3 = (TextView) view.findViewById(R.id.master_item_3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onMasterItemClicked(3);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
}
