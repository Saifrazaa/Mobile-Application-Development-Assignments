package com.example.user.chaishack;

/**
 * Created by User on 29-Nov-19.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



    public class IntroViewPagerAdapter extends PagerAdapter {

        Context mContext ;
        List<Screenitem> mListScreen;

        public IntroViewPagerAdapter(Context mContext, List<Screenitem> mListScreen) {
            this.mContext = mContext;
            this.mListScreen = mListScreen;
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

            ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
            TextView title = layoutScreen.findViewById(R.id.intro_title);
            TextView description = layoutScreen.findViewById(R.id.intro_description);

            title.setText(mListScreen.get(position).getTitle());
            description.setText(mListScreen.get(position).getDescription());
            imgSlide.setImageResource(mListScreen.get(position).getScreenImg());

            container.addView(layoutScreen);

            return layoutScreen;





        }

        @Override
        public int getCount() {
            return mListScreen.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View)object);

        }
    }


