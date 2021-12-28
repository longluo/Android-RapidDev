package io.github.longluo.baseframework.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import io.github.longluo.baseframework.BaseFragment;

import java.util.List;

/**

 * @createTime: 2020/11/20 13:22
 */
public class DefaultViewPagerAdapter extends FragmentPagerAdapter {
    
    private List<BaseFragment> viewList;
    
    public DefaultViewPagerAdapter(FragmentManager fm, List<BaseFragment> viewList) {
        super(fm);
        this.viewList = viewList;
    }
    
    @Override
    public int getCount() {
        return viewList.size();
    }
    
    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = viewList.get(position);
        return fragment;
    }
}
