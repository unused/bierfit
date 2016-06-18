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

                    Toast.makeText(getApplicationContext(), "not loged in", Toast.LENGTH_SHORT).show();

                    ((TextView)findViewById(R.id.username)).setText("not logged in");
                    ((TextView)findViewById(R.id.email)).setText("you need to log in");
                } else {
                    ((TextView)findViewById(R.id.username)).setText("TODO username");
                    ((TextView)findViewById(R.id.email)).setText("TODO email");
                }
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawer.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();



//        Fragment home = new HomeFragment();
//        fragmentTransaction.replace(R.id.fragment_home, home);
//
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();

        /**
         * Buttons
         */

//        Button learnmore = (Button) findViewById(R.id.button_learnmore);
//        learnmore.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Open GitHub", Toast.LENGTH_SHORT).show();
//
//                String url = "https://github.com/unused/bierfit";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//
//            }
//        });
//
//        Button signup = (Button) findViewById(R.id.button_signup);
//        signup.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Signup", Toast.LENGTH_SHORT).show();
//                            }
//        });
//
//        Button login = (Button) findViewById(R.id.button_login);
//        login.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
//                logedIn = true;
//            }
//        });

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

        //Check to see which item was being clicked and perform appropriate action
        switch (menuItem.getItemId()) {

            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT).show();

                fragmentClass = HomeFragment.class;
                break;
    //                        HomeFragment homeFragment = new HomeFragment();
    //                        fragmentTransaction.replace(R.id.fragment_main, homeFragment);
    //                        fragmentTransaction.commit();
    //                        Fragment home = new HomeFragment();
    //                        fragmentTransaction.replace(R.id.fragment_home, home);
    //
    //                        fragmentTransaction.addToBackStack(null);
    //                        fragmentTransaction.commit();

            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(), "Profile Selected", Toast.LENGTH_SHORT).show();
    //                        LoginFragment loginFragment = new LoginFragment();
    //                        fragmentTransaction.replace(R.id.frame, loginFragment);
    //                        fragmentTransaction.commit();
    //                        toolbar.setTitle("hugo");

                //fLayout.setVisibility(View.GONE);
                break;
            case R.id.nav_dashboard:
                Toast.makeText(getApplicationContext(), "Dashboard Selected", Toast.LENGTH_SHORT).show();
    //                        ContentFragment contentFragment = new ContentFragment();
    //                        fragmentTransaction.replace(R.id.frame, contentFragment);
    //                        fragmentTransaction.commit();

                //fLayout.setVisibility(View.GONE);
                break;
            default:
                Toast.makeText(getApplicationContext(), "not implemented yet", Toast.LENGTH_SHORT).show();
                break;
        }
        // For rest of the options we just show a toast on click

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        fragmentTransaction.replace(R.id.flContet, fragment);
        fragmentTransaction.commit();
        //mDrawer.closeDrawer();
    }

}
