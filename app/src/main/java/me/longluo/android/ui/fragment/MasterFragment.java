package me.longluo.android.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import me.longluo.android.R;
import me.longluo.android.ui.activity.GreenDaoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MasterFragment extends Fragment {

    private Callbacks callbacks;

    @BindView(R.id.master_item_1)
    TextView textView1;

    @BindView(R.id.master_item_2)
    TextView textView2;

    @BindView(R.id.master_item_3)
    TextView textView3;

    @BindView(R.id.tv_greendao)
    TextView tvGreenDao;

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

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    @OnClick({R.id.master_item_1, R.id.master_item_2, R.id.master_item_3, R.id.tv_greendao})
    void click(View view) {
        switch (view.getId()) {
            case R.id.master_item_1:
                callbacks.onMasterItemClicked(1);
                break;

            case R.id.master_item_2:
                callbacks.onMasterItemClicked(2);
                break;

            case R.id.master_item_3:
                callbacks.onMasterItemClicked(3);
                break;

            case R.id.tv_greendao:
                Intent intent = new Intent(getActivity(), GreenDaoActivity.class);
                getActivity().startActivity(intent);
                break;

            default:
                break;
        }
    }

}
