package com.indexer.psi;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.test.InstrumentationTestCase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends InstrumentationTestCase {
    private MockWebServer server;
    private GoogleMap googleMap;
    @Rule
    public UiThreadTestRule threadTestRule = new UiThreadTestRule();


    @Before
    public void setUp() throws Exception {
        super.setUp();
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        final SupportMapFragment mapFragment = mActivityRule.getActivity().mapFragment;

        final OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                MainActivityTest.this.googleMap = googleMap;
            }
        };

        try {
            threadTestRule.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mapFragment.getMapAsync(onMapReadyCallback);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    @Test
    public void readAppAsset() throws Exception {
        Context ctx = InstrumentationRegistry.getTargetContext();
        InputStream is = ctx.getResources().getAssets().open("psi.json");
        String s = readTextStream(is);
        Assert.assertNotNull(s);
    }


    public static String readTextStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);


    @Test
    public void dataisShowinMainActivity() throws Exception {
        Context ctx = InstrumentationRegistry.getTargetContext();
        InputStream is = ctx.getResources().getAssets().open("psi.json");
        String s = readTextStream(is);
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(s));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        onView(withText("National Wide Data")).check(matches(isDisplayed()));

        onView(withId(R.id.national_date)).check((ViewAssertion) isSelected()).equals(true);

        assertEquals(GoogleMap.MAP_TYPE_HYBRID, googleMap.getMapType());


    }


}