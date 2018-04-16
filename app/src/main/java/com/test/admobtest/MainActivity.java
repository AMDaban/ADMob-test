package com.test.admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private final String TAG = "ADMobTest";

    /**
     * Interstitial Ad
     */
    private InterstitialAd interstitialAd = null;

    /**
     * Interstitial Ad
     */
    private InterstitialAd interstitialVideoAd = null;

    /**
     * Rewarded Video Ad
     */
    private RewardedVideoAd rewardedVideoAd = null;

    /**
     * Show Rewarded Video Ad
     */
    private Button showRewardedVideoAd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         *  initialize ADMob
         */
        MobileAds.initialize(this, Constants.appId);

        /* banner ads */

        /*
         *  create a new banner ad
         */
        AdView mAdView = findViewById(R.id.adView);

        /*
         *  add event handlers to banner ad
         */
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i(TAG, "Banner - onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.e(TAG, "Banner - onAdFailedToLoad - error code : " + errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i(TAG, "Banner - onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i(TAG, "Banner - onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i(TAG, "Banner - onAdClosed");
            }
        });

        /*
         *  finally request banner ad
         */
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        /* end of implementation of banner ads */

        /* interstitial ads */

        /*
         *  show the interstitial ad
         */
        final Button showAd = findViewById(R.id.btnShowAd);
        showAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else {
                    Log.d(TAG, "Interstitial - The interstitial wasn't loaded yet.");
                }
            }
        });
        showAd.setEnabled(false);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(Constants.interstitialAdUnitId);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i(TAG, "Interstitial - onAdLoaded");

                showAd.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i(TAG, "Interstitial - onAdFailedToLoad - error code : " + errorCode);

                showAd.setEnabled(false);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i(TAG, "Interstitial - onAdOpened");

                showAd.setEnabled(false);
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i(TAG, "Interstitial - onAdLeftApplication");

                showAd.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i(TAG, "Interstitial - onAdClosed");

                showAd.setEnabled(false);
            }
        });

        Button requestInterstitialButton = findViewById(R.id.btnInterstitial);
        requestInterstitialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                 *  request interstitial ad
                 */
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        /* end of implementation of interstitial ads */

        /* Interstitial Video Ads */

        /*
         *  show the interstitial ad
         */
        final Button showInterstitialVideoAd = findViewById(R.id.btnShowInterstitialVideo);
        showInterstitialVideoAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (interstitialVideoAd.isLoaded()) {
                    interstitialVideoAd.show();
                } else {
                    Log.d(TAG, "InterstitialVideo - The interstitial wasn't loaded yet.");
                }
            }
        });
        showInterstitialVideoAd.setEnabled(false);

        interstitialVideoAd = new InterstitialAd(this);
        interstitialVideoAd.setAdUnitId(Constants.intestitialVideoAdUnitId);

        interstitialVideoAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i(TAG, "InterstitialVideo - onAdLoaded");

                showInterstitialVideoAd.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i(TAG, "InterstitialVideo - onAdFailedToLoad - error code : " + errorCode);

                showInterstitialVideoAd.setEnabled(false);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.i(TAG, "InterstitialVideo - onAdOpened");

                showInterstitialVideoAd.setEnabled(false);
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i(TAG, "InterstitialVideo - onAdLeftApplication");

                showInterstitialVideoAd.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i(TAG, "InterstitialVideo - onAdClosed");

                showInterstitialVideoAd.setEnabled(false);
            }
        });

        Button requestInterstitialVideoButton = findViewById(R.id.btnInterstitialVideoAd);
        requestInterstitialVideoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                 *  request interstitial ad
                 */
                interstitialVideoAd.loadAd(new AdRequest.Builder().build());
            }
        });

        /* end of implementing Interstitial Video Ads */

        /* Rewarded Video Ads */

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);


        showRewardedVideoAd = findViewById(R.id.btnShowRewarded);
        showRewardedVideoAd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show();

                    showRewardedVideoAd.setEnabled(false);
                }
            }
        });
        showRewardedVideoAd.setEnabled(false);

        Button requestRewardedButton = findViewById(R.id.btnRewarded);
        requestRewardedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                 *  request rewarded video ad
                 */
                rewardedVideoAd.loadAd(
                        Constants.rewardedVideoAdUnitId,
                        new AdRequest.Builder().build()
                );
            }
        });

        /* end of implementation of rewarded ads */
    }

    /*
     * these functions are related to Rewarded Video Ads
     */

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.i(TAG, "Rewarded - onRewardedVideoAdLoaded");

        showRewardedVideoAd.setEnabled(true);
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.i(TAG, "Rewarded - onRewardedVideoAdOpened");
    }

    @Override
    public void onRewardedVideoStarted() {
        Log.i(TAG, "Rewarded - onRewardedVideoStarted");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Log.i(TAG, "Rewarded - onRewardedVideoAdClosed");
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Log.i(TAG, "Rewarded - onRewarded : " + rewardItem.toString());
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Log.i(TAG, "Rewarded - onRewardedVideoAdLeftApplication");
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Log.i(TAG, "Rewarded - onRewardedVideoAdFailedToLoad : " + errorCode);
    }

    @Override
    public void onRewardedVideoCompleted() {
        Log.i(TAG, "Rewarded - onRewardedVideoCompleted");
    }
}
