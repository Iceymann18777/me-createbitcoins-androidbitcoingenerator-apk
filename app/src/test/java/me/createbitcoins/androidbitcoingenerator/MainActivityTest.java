package me.createbitcoins.androidbitcoingenerator;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.Contract;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
 
public class MainActivityTest {

 
    @Test
    public void testOnCreate() { 
        // Initialize the object to be tested
        MainActivity mainActivity = ObjectInit.random(MainActivity.class);
        // Initialize params of the method
        
        Bundle bundle = ObjectInit.random(Bundle.class);;
        mainActivity.onCreate(bundle);

        // Write the Assert code
        Assert.assertTrue(true);
        //Assert.assertEquals(expected, actual);
    }

 
    @Test
    public void testOnNavigationItemSelected() { 
        // Initialize the object to be tested
        MainActivity mainActivity = ObjectInit.random(MainActivity.class);
        // Initialize params of the method
        
        MenuItem menuItem = (MenuItem) ObjectInit.random(MenuItem.class);;
        Objects.requireNonNull(mainActivity).onNavigationItemSelected(Objects.requireNonNull(menuItem));

        // Write the Assert code
        //Assert.assertEquals(expected, invokeResult);
    }

 
    @Test
    public void testOnBackPressed() { 
        // Initialize the object to be tested
        MainActivity mainActivity = ObjectInit.random(MainActivity.class);
        assert mainActivity != null;
        mainActivity.onBackPressed();

        // Write the Assert code
        Assert.assertTrue(true);
    }

    @Test
    public void random() {
    }

    @Test
    public void getMainActivityClass() {
    }

    @Test
    public void setMainActivityClass() {
    }

    @Test
    public void testRandom() {
    }

    @Test
    public void testGetMainActivityClass() {
    }

    @Test
    public void testSetMainActivityClass() {
    }

    @Test
    public void testRandom1() {
    }

    private static class ObjectInit {
        private static Class<MainActivity> mainActivityClass;

        @Nullable
        public static MainActivity random(Class<MainActivity> mainActivityClass) {
            ObjectInit.mainActivityClass = mainActivityClass;
            return null;
        }

        public static Class<MainActivity> getMainActivityClass() {
            return mainActivityClass;
        }

        public static void setMainActivityClass(Class<MainActivity> mainActivityClass) {
            ObjectInit.mainActivityClass = mainActivityClass;
        }

        @Nullable
        @Contract(pure = true)
        public static MainActivity random(Class<MainActivity> mainActivityClass) {
            ObjectInit.mainActivityClass = mainActivityClass;
            return null;
        }

        public static Bundle random(Class<Bundle> bundleClass) {
            return null;
        }
    }
}