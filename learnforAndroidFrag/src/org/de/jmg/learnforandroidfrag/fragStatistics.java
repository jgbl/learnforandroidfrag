package org.de.jmg.learnforandroidfrag;

import org.de.jmg.learn.chart.LearnBarChart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragStatistics extends Fragment 
{
	public final static int fragID = 2;	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		LearnBarChart chart = new LearnBarChart();
		return chart.getView((MainActivity) getActivity());
	}
}
