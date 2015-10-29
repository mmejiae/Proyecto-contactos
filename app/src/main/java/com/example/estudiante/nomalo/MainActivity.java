package com.example.estudiante.nomalo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.example.estudiante.nomalo.adapter.ViewPagerAdapter;
import com.example.estudiante.nomalo.fragment.DummyFragment;
import com.example.estudiante.nomalo.fragment.NuevoContacto;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)Toolbar mtoolbar;
    @Bind(R.id.tab_layout) TabLayout mTablayout;
    @Bind(R.id.viewpager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mtoolbar);
        mTablayout.addTab(mTablayout.newTab().setText("TAB1"));
        mTablayout.addTab(mTablayout.newTab().setText("NUEVO CONTACTO"));

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter((getSupportFragmentManager()));
        viewPagerAdapter.addFrag(new DummyFragment());
        viewPagerAdapter.addFrag(new NuevoContacto());

        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));

        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch (tab.getPosition()) {
                  case 0:
                  Log.d("AGENDACONTACTOS", "TAB#1");
                  break;
                  case 1:
                      Log.d("AGENDACONTACTOS", "NUEV0 CONTACTO");
                      break;

              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            });


    }
}
