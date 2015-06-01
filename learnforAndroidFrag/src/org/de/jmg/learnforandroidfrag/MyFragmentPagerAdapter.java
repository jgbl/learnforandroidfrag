package org.de.jmg.learnforandroidfrag;

import org.de.jmg.lib.lib;

import br.com.thinkti.android.filechooserfrag.fragFileChooser;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
	
	final int PAGE_COUNT = 4;
	public _MainActivity fragMain;
	public SettingsActivity fragSettings;
	public br.com.thinkti.android.filechooserfrag.fragFileChooser fragChooser;
	public MainActivity main;
	public fragStatistics fragChart;
	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm, MainActivity main, boolean restart) {
		super(fm);
		this.main = main;
		try
		{
			if (restart) 
			{
				LayoutInflater Li = LayoutInflater.from(main);
				for (Fragment f: fm.getFragments())
				{
					if (f instanceof _MainActivity) 
					{
						fragMain = (_MainActivity) f;
						fragMain._main = main;
					}
					else if (f instanceof SettingsActivity)
					{
						fragSettings = (SettingsActivity) f;
						fragSettings._main = main;
						
					}
					else if (f instanceof fragFileChooser)
					{
						fragChooser = (fragFileChooser) f;
						fragChooser._main = main;
						fragChooser.onCreateView(Li, main.Layout, null);
					}
					else if (f instanceof fragStatistics)
					{
						fragChart = (fragStatistics) f;
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
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
					if (main!=null) fragChooser.init(main.getFileChooserIntent(true),main);
				}
				LastItem = fragChooser;
				return fragChooser;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				lib.ShowException(main, e);
			}
				
			case fragStatistics.fragID:
			if (fragChart==null)
			{
				fragChart = new fragStatistics();
			}
			LastItem = fragChart;
			return fragChart;
				
				
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

	
}
