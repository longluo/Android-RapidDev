package me.longluo.android.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import me.longluo.android.R;


public class DetailFragment extends Fragment {
    private static final String TAG = DetailFragment.class.getSimpleName();

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private int nonSelectedColor;
    private int selectedColor;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        textView1 = (TextView) view.findViewById(R.id.detail_item_1);
        textView2 = (TextView) view.findViewById(R.id.detail_item_2);
        textView3 = (TextView) view.findViewById(R.id.detail_item_3);

        selectedColor = ContextCompat.getColor(getContext(), R.color.red);
        nonSelectedColor = ContextCompat.getColor(getContext(), R.color.black);

        return view;
    }

    /**
     * It's really up to you to decide what happens when a master item is clicked... This is all
     * arbitrary.
     *
     * @param masterId
     */
    public void onMasterItemClicked(int masterId) {
        // reset colors
        textView1.setTextColor(nonSelectedColor);
        textView2.setTextColor(nonSelectedColor);
        textView3.setTextColor(nonSelectedColor);

        switch (masterId) {
            case 1:
                textView1.setTextColor(selectedColor);
                break;

            case 2:
                textView2.setTextColor(selectedColor);
                break;

            case 3:
                textView3.setTextColor(selectedColor);
                break;

            default:
                Log.d(TAG, "unknown master ID");
        }
    }
}
