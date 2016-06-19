package bierfit.mybierfit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public boolean isLogedIn() {
        return logedIn;
    }

    public void setLogedIn(boolean logedIn) {
        this.logedIn = logedIn;
    }

    private boolean logedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logedIn = false;
        // Attaching the layout to the toolbar object
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        setupDrawnerContent(navigationView);

        // Initializing Drawer Layout and ActionBarToggle
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);

                //no user loged in
                if(logedIn == false) {

                    Toast.makeText(getApplicationContext(),"not logged in", Toast.LENGTH_SHORT).show();
                    ((TextView)drawerView.findViewById(R.id.username)).setText("not logged in");
                    ((TextView)drawerView.findViewById(R.id.email)).setText("you need to log in");

                    ((NavigationView)drawerView).getMenu().findItem(R.id.nav_logout).setVisible(false);
                } else {
                    Toast.makeText(getApplicationContext(), "logged in", Toast.LENGTH_SHORT).show();

                    ((TextView)drawerView.findViewById(R.id.username)).setText("TODO username");
                    ((TextView)drawerView.findViewById(R.id.email)).setText("TODO email");

                    ((NavigationView)drawerView).getMenu().findItem(R.id.nav_logout).setVisible(true);
                }
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawer.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();



        try {
            fragmentTransaction.replace(R.id.flContet, (Fragment)HomeFragment.class.newInstance());
//            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fragmentManager.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupDrawnerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        selectDrawnerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawnerItem(MenuItem menuItem) {

        //Checking if the item is in checked state or not, if not make it in checked state
        if (menuItem.isChecked()) menuItem.setChecked(false);
        else menuItem.setChecked(true);

        //Closing drawer on item click
        mDrawer.closeDrawers();

        Fragment fragment = null;
        Class fragmentClass = null;

        boolean newFragment = true;
        //Check to see which item was being clicked and perform appropriate action
        switch (menuItem.getItemId()) {

            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT).show();
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(), "Profile selected", Toast.LENGTH_SHORT).show();
                fragmentClass = ProfileFragment.class;
                break;
            case R.id.nav_dashboard:
                Toast.makeText(getApplicationContext(), "Dashboard selected", Toast.LENGTH_SHORT).show();
                fragmentClass = ContentFragment.class;
                break;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(), "Settings selected", Toast.LENGTH_SHORT).show();
                fragmentClass = SettingsFragment.class;
                break;
            case R.id.nav_github:

                newFragment = false;
                String url = this.getResources().getString(R.string.github);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.nav_logout:
                setLogedIn(false);
                Toast.makeText(getApplicationContext(), "logged out", Toast.LENGTH_SHORT).show();
                fragmentClass = HomeFragment.class;
                break;
            default:
                Toast.makeText(getApplicationContext(), "not implemented yet", Toast.LENGTH_SHORT).show();
                break;
        }
        if(newFragment) {
            // For rest of the options we just show a toast on click

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.flContet, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}
