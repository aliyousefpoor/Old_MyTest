package com.example.ali.mytest.Activity;

import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ali.mytest.Fragment.FragmentFive;
import com.example.ali.mytest.Fragment.FragmentFour;
import com.example.ali.mytest.Fragment.FragmentOne;
import com.example.ali.mytest.Fragment.FragmentThree;
import com.example.ali.mytest.Fragment.FragmentTwo;
import com.example.ali.mytest.Fragment.HomeFragment;
import com.example.ali.mytest.Fragment.MoviesFragment;
import com.example.ali.mytest.Fragment.NotificationsFragment;
import com.example.ali.mytest.Fragment.PhotosFragment;
import com.example.ali.mytest.Fragment.SettingsFragment;
import com.example.ali.mytest.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private View navHeader;
    //    private ImageView imgNavHeaderBg, imgProfile;
//    private TextView txtName, txtWebsite;
    private Toolbar toolbar;


    //    private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
//    private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";
//    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "notifications";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
//    private String[] activityTitles;

    // flag to load home fragment when user presses back key
//    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    NavigationView nv_view;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nv_view = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent(nv_view);

//
//        // Navigation view header
//        navHeader = nv_view.getHeaderView(0);
//        txtName = (TextView) navHeader.findViewById(R.id.name);
//        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
//        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
//        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // load toolbar titles from string resources
//        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);


        navigation.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = FragmentOne.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = FragmentTwo.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = FragmentThree.newInstance();
                                break;
                            case R.id.action_item4:
                                selectedFragment = FragmentFour.newInstance();
                                Toast.makeText(MainActivity.this, "اطلاعات را وارد کنید", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentFive.newInstance());
        transaction.commit();


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }


                });

    }


    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = HomeFragment.class;
                Toast.makeText(MainActivity.this, "sndansdkasd", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_photos:
                fragmentClass = PhotosFragment.class;
                break;
            case R.id.nav_movies:
                fragmentClass = MoviesFragment.class;
                break;
            case R.id.nav_notifications:
                fragmentClass= NotificationsFragment.class;
                break;
            case R.id.nav_settings:
                fragmentClass= SettingsFragment.class;
                break;
            default:
                fragmentClass = FragmentFive.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawer.closeDrawers();
    }

}



//        //Manually displaying the first fragment - one time only
//        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
//        transaction1.replace(R.id.frame_layout, FragmentFive.newInstance());
//        transaction1.commit();
//
//
//        // load nav menu header data
//        loadNavHeader();
//
//        // initializing navigation menu
//        // setUpNavigationView();
//
//        if (savedInstanceState == null) {
//            navItemIndex = 0;
//            CURRENT_TAG = TAG_HOME;
//            // loadHomeFragment();
//        }
//    }
//
//    /***
//     * Load navigation menu header information
//     * like background image, profile image
//     * name, website, notifications action view (dot)
//     */
//    private void loadNavHeader() {
//        // name, website
//        txtName.setText("Ali");
//        txtWebsite.setText("www.ali.info");
//
//        // loading header background image
//        Glide.with(this).load(urlNavHeaderBg)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgNavHeaderBg);
//
//        // Loading profile image
//        Glide.with(this).load(urlProfileImg)
//                .crossFade()
//                .thumbnail(0.5f)
//                .bitmapTransform(new CircleTransform(this))
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgProfile);
//
//        // showing dot next to notifications label
//
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
////        if (id == android.R.id.home) {
////            mDrawerLayout.openDrawer(GravityCompat.START);
////        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//}
//
//
///***
// * Returns respected fragment that user
// * selected from navigation menu
// */
//    private void loadHomeFragment() {
//        // selecting appropriate nav menu item
//        selectNavMenu();
//
//        // set toolbar title
//        setToolbarTitle();
//
//        // if user select the current navigation menu again, don't do anything
//        // just close the navigation drawer
//        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
//            drawer.closeDrawers();
//
//
//            return;
//        } }
//
//        // Sometimes, when fragment has huge data, screen seems hanging
//        // when switching between navigation menus
//        // So using runnable, the fragment is loaded with cross fade effect
//
//
//
//    private void setToolbarTitle() {
//        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
//    }
//
//    private void selectNavMenu() {
//        nv_view.getMenu().getItem(navItemIndex).setChecked(true);
//    }
//
//    private void setUpNavigationView() {
//        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
//        nv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//            // This method will trigger on item Click of navigation menu
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                //Check to see which item was being clicked and perform appropriate action
//                switch (menuItem.getItemId()) {
//                    //Replacing the main content with ContentFragment Which is our Inbox View;
//                    case R.id.nav_home:
//                        navItemIndex = 0;
//                        CURRENT_TAG = TAG_HOME;
//                        loadHomeFragment();
//                        break;
//                    case R.id.nav_photos:
//                        navItemIndex = 1;
//                        CURRENT_TAG = TAG_PHOTOS;
//
//                        break;
//
//                    case R.id.nav_movies:
//                        navItemIndex = 2;
//                        CURRENT_TAG = TAG_MOVIES;
//                        break;
//                    case R.id.nav_notifications:
//                        navItemIndex = 3;
//                        CURRENT_TAG = TAG_NOTIFICATIONS;
//                        break;
//                    case R.id.nav_settings:
//                        navItemIndex = 4;
//                        CURRENT_TAG = TAG_SETTINGS;
//                        break;
//                    case R.id.nav_about_us:
//                        // launch new intent instead of loading fragment
//                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
//                        drawer.closeDrawers();
//                        return true;
//
//                    default:
//                        navItemIndex = 0;
//                }
//
//                //Checking if the item is in checked state or not, if not make it in checked state
//                if (menuItem.isChecked()) {
//                    menuItem.setChecked(false);
//                } else {
//                    menuItem.setChecked(true);
//                }
//                menuItem.setChecked(true);
//
//                loadHomeFragment();
//
//                return true;
//            }
//        });
//
//
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
//
//
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
//                super.onDrawerOpened(drawerView);
//            }
//        };
//
//        //Setting the actionbarToggle to drawer layout
//        drawer.setDrawerListener(actionBarDrawerToggle);
//
//        //calling sync state is necessary or else your hamburger icon wont show up
//        actionBarDrawerToggle.syncState();
//    }
//
//
//    }
//
//
//





