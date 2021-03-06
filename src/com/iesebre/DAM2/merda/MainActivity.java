package com.iesebre.DAM2.merda;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_new:
	        	setContentView(R.layout.nou);
	            Toast nou = Toast.makeText(MainActivity.this, "Has creat un registre nou", 3);
	            nou.show();
	            return true;
	        case R.id.menu_save:
	        	Toast save = Toast.makeText(MainActivity.this, "Guardat", 3);
	        	save.show();
	            return true;
	        case R.id.menu_ajustos:
	        	setContentView(R.layout.settings);
	        	Toast ajustos = Toast.makeText(MainActivity.this, "Has entrat a Ajustes", 3);
	        	ajustos.show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		
		
		
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Fragment fragment2 = new DummySectionFragment2();
			Fragment fragment3 = new DummySectionFragment3();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 2);
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 3);
			fragment.setArguments(args);
			fragment2.setArguments(args);
			fragment3.setArguments(args);
			switch (position) {
			case 0:
				return fragment;
			case 1:
				return fragment2;
			case 2:
				return fragment3;
			}
			return null;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}
	 public static class DummySectionFragment2 extends Fragment { 
		/** * The fragment argument representing the section number for this * fragment. */ 
		 public static final String ARG_SECTION_NUMBER = "section_number"; 
		 public DummySectionFragment2() { } 
		 @Override 
		 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
		 { View rootView2 = inflater.inflate(R.layout.settings, container, false);
		 return rootView2; }
		 }
	 public static class DummySectionFragment3 extends Fragment 
	 { /** * The fragment argument representing the section number for this * fragment. */
		 public static final String ARG_SECTION_NUMBER = "section_number_3";
		 public DummySectionFragment3() { } 
		 @Override 
		 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		 { View rootView3 = inflater.inflate(R.layout.nou, container, false);
		 return rootView3; } 
		 }

}
