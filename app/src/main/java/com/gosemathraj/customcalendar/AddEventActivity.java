package com.gosemathraj.customcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gosemathraj.customcalendar.fragments.AddEventFragment;
import com.gosemathraj.customcalendar.fragments.EventDetailsFragment;
import com.gosemathraj.customcalendar.model.Events;

/**
 * Created by RajeshG on 01-03-2017.
 */
public class AddEventActivity extends AppCompatActivity implements AddEventFragment.AddeventClicked,
        EventDetailsFragment.OnEventDelete{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_activity);

        if(savedInstanceState == null){
            getIntentData();
        }
    }

    private void getIntentData() {
        int fragmentId = getIntent().getExtras().getInt("fragmentId");
        if(fragmentId == 1){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_base_container,new AddEventFragment()).commit();
        }else if(fragmentId == 2){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_base_container,new EventDetailsFragment()).commit();
        }
    }

    @Override
    public void onAddEventClicked(Bundle bundle) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtras(bundle);
        setResult(1,intent);
        finish();
    }

    @Override
    public void eventDelete(Events event) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("deleteEvent",event);

        Intent newIntent = new Intent(this,MainActivity.class);
        newIntent.putExtras(bundle);
        setResult(2,newIntent);
        finish();
    }
}
