package me.createbitcoins.androidbitcoingenerator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Fragment HomeFragment;
    private DrawerLayout drawer;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int Activity_Main = 0;
        setContentView(Activity_Main);
        Toolbar toolbar = findViewById(C0458R.C0460id.toolbar);
        setSupportActionBar(toolbar);
        this.drawer = findViewById(C0458R.C0460id.drawer_layout);
        NavigationView navigationView = findViewById(C0458R.C0460id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, toolbar, C0458R.string.navigation_drawer_open, C0458R.string.navigation_drawer_close);
        this.drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(C0458R.C0460id.fragment_container, new HomeFragment()).commit();
        navigationView.setCheckedItem(C0458R.C0460id.nav_home);
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0458R.C0460id.about) {
            getSupportFragmentManager().beginTransaction().replace(C0458R.C0460id.fragment_container, new AboutFragment()).commit();
        } else if (itemId == C0458R.C0460id.contact) {
            getSupportFragmentManager().beginTransaction().replace(C0458R.C0460id.fragment_container, new ContactFragment()).commit();
        } else if (itemId == C0458R.C0460id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(C0458R.C0460id.fragment_container, new HomeFragment()).commit();
        }
        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            this.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
