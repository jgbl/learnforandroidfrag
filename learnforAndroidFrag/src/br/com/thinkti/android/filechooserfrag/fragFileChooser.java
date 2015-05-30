package br.com.thinkti.android.filechooserfrag;
import org.de.jmg.learnforandroidfrag.*;
import br.com.thinkti.android.filechooser.FileArrayAdapter;
import br.com.thinkti.android.filechooser.Option;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class fragFileChooser extends ListFragment 
{
	public final static int fragID = 1;
	private File currentDir;
	private FileArrayAdapter adapter;
	private FileFilter fileFilter;
	private File fileSelected;
	private boolean unicode;
	private String DefaultDir;
	private ArrayList<String> extensions;
	public MainActivity _main;
	private View _chooserView;
	private Intent _Intent;
	private boolean _blnInitialized;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		_chooserView = super.onCreateView(inflater, container, savedInstanceState);
		init();
		return _chooserView;
	}
	
	public void init(Intent intent, MainActivity main)
	{
			_main = main;
			_Intent = intent;
	}
	
	public void init()
	{
		if (_main==null||_Intent==null||_chooserView==null||_blnInitialized)
		{
			return;
		}
		try
		{
			Bundle extras = _Intent.getExtras();
			if (extras != null) 
			{
				unicode = extras.getBoolean("blnUniCode", true);
				DefaultDir = extras.getString("DefaultDir");
				if (extras.getStringArrayList("filterFileExtension") != null) {
					extensions = extras.getStringArrayList("filterFileExtension");				
					fileFilter = new FileFilter() {
						@Override
						public boolean accept(File pathname) 
						{						
							return ((pathname.isDirectory()) 
									|| ExtensionsMatch(pathname));
						}
					};
				}
			}
			
			
			if (DefaultDir == null || DefaultDir.length()==0) DefaultDir=Environment.getExternalStorageDirectory().getPath();
			currentDir = new File(DefaultDir);
			Toast.makeText(_main, "Loading " + currentDir.getPath(), Toast.LENGTH_LONG).show();
			fill(currentDir);
			_blnInitialized=true;
		}
		catch(Exception ex)
		{
			Toast.makeText(_main, "Error " + ex.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_main = (org.de.jmg.learnforandroidfrag.MainActivity)getActivity();
	}
	
	private boolean ExtensionsMatch(File pathname)
	{
		String ext;
		if(pathname.getName().contains("."))
		{
			ext = pathname.getName().substring(pathname.getName().lastIndexOf("."));
		}
		else
		{
			return false;
		}
		
		if (extensions.contains(ext)) return true;
		
		for(String itext: extensions)
		{
			itext = itext.replace(".", "\\.");
			itext = itext.toLowerCase();
			ext = ext.toLowerCase();
			if (ext.matches(itext.replace("?", ".{1}").replace("*", ".*")))
					{
						return true;
					}
		}
		
		return false;
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	if ((!currentDir.getName().equals("sdcard")) && (currentDir.getParentFile() != null)) {
        		AlertDialog.Builder A = new AlertDialog.Builder(getActivity());
				A.setPositiveButton(getString(R.string.yes),
						new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								_main.mPager.setCurrentItem(_MainActivity.fragID);
							}
						});
				A.setNegativeButton(getString(R.string.no),
						new AlertDialog.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) 
							{
								currentDir = currentDir.getParentFile();
					        	fill(currentDir);
							}
						});
				A.setMessage(getString(R.string.quit));
				A.setTitle("Question");
				A.show();

        		
        	} else {
        		_main.mPager.setCurrentItem(_MainActivity.fragID);
        	}
            return false;
        }
        return true;
	}

	private void fill(File f) {
		File[] dirs = null;
		if (fileFilter != null)
			dirs = f.listFiles(fileFilter);
		else 
			dirs = f.listFiles();
			
		_main.setTitle(getString(R.string.currentDir) + ": " + f.getName());
		List<Option> dir = new ArrayList<Option>();
		List<Option> fls = new ArrayList<Option>();
		try {
			for (File ff : dirs) {
				if (ff.isDirectory() && !ff.isHidden())
					dir.add(new Option(ff.getName(), getString(R.string.folder), ff
							.getAbsolutePath(), true, false, false));
				else {
					if (!ff.isHidden())
						fls.add(new Option(ff.getName(), getString(R.string.fileSize) + ": "
								+ ff.length(), ff.getAbsolutePath(), false, false, false));
				}
			}
		} catch (Exception e) {

		}
		Collections.sort(dir);
		Collections.sort(fls);
		dir.addAll(fls);
		if (!f.getName().equalsIgnoreCase("sdcard")) {
			if (f.getParentFile() != null) dir.add(0, new Option("..", getString(R.string.parentDirectory), f.getParent(), false, true, false));
		}
		adapter = new FileArrayAdapter(getActivity(), R.layout.file_view,
				dir);
		this.setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) 
	{
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Option o = adapter.getItem(position);
		if (o.isFolder() || o.isParent()) {			
			currentDir = new File(o.getPath());
			fill(currentDir);
		} else {
			//onFileClick(o);
			fileSelected = new File(o.getPath());
			Intent intent = new Intent();
			intent.putExtra("fileSelected", fileSelected.getAbsolutePath());
			intent.putExtra("blnUniCode", this.unicode);
			_main.onActivityResult(MainActivity.FILE_CHOOSER, Activity.RESULT_OK, intent);
			_main.mPager.setCurrentItem(_MainActivity.fragID);
		}		
	}
//
//	private void onFileClick(Option o) {
//		Toast.makeText(this, "File Clicked: " + o.getName(), Toast.LENGTH_SHORT)
//				.show();
//	}		
}