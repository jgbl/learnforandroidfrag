package org.de.jmg.learnforandroidfrag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
	
	final int PAGE_COUNT = 2;
	public final _MainActivity fragMain = new _MainActivity();
	public final SettingsActivity fragSettings = new SettingsActivity();
	
	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		
			/** tab1 is selected */
			case 0:
				
				
				return fragMain;
				
			/** tab2 is selected */
			case 1:
				return fragSettings;	
		}
		
		return null;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {		
		return PAGE_COUNT;
	}
	
}
