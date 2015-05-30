package org.de.jmg.learnforandroidfrag;

import org.de.jmg.lib.lib;

import br.com.thinkti.android.filechooserfrag.fragFileChooser;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
	
	final int PAGE_COUNT = 3;
	public _MainActivity fragMain;
	public SettingsActivity fragSettings;
	public br.com.thinkti.android.filechooserfrag.fragFileChooser fragChooser;
	public MainActivity main;
	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm, MainActivity main) {
		super(fm);
		this.main = main;
	}

	/** This method will be invoked when a page is requested to create */
	public Fragment LastItem;
	
	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		
			/** tab1 is selected */
			case _MainActivity.fragID:
				if (fragMain == null)
				{
					fragMain = new _MainActivity();
				}
				LastItem = fragMain;
				return fragMain;
				
			case fragFileChooser.fragID:
			try {
				if (fragChooser==null) 
					{
						fragChooser=new fragFileChooser();
						fragChooser.init(main.getFileChooserIntent(true),main);
					}
				if (main.checkLoadFile())
				{
					LastItem = fragChooser;
					return fragChooser;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				lib.ShowException(main, e);
			}
				
				
			/** tab2 is selected */
			case SettingsActivity.fragID:
				if (fragSettings==null)
				{
					fragSettings = new SettingsActivity();
					fragSettings.init(main.getSettingsIntent(),main);
				}
				LastItem = fragSettings;
				return fragSettings;	
		}
		
		return null;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {		
		return PAGE_COUNT;
	}

	public void init(Intent intent, int settingsActivity) {
		// TODO Auto-generated method stub
		
	}
	
}
