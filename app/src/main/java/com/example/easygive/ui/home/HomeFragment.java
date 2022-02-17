package com.example.easygive.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easygive.R;
import com.example.easygive.databinding.FragmentHomeBinding;
import com.example.easygive.models.Mission;
import com.example.easygive.models.MissionsAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private DatabaseReference mDatabase;
    private static final String TAG = "HomeFragment";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final LinearLayout preferencesTage = root.findViewById(R.id.preferences_tags);
        setupMissionsList(root.findViewById(R.id.missions_lst));
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot pref : snapshot.child("users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("preferences").getChildren()) {
                    Log.i(TAG, "onDataChange: pref " + pref.getValue());
                    TextView tag = new TextView(getContext());
                    tag.setBackground(getContext().getDrawable(R.drawable.tag));
                    tag.setPadding(20,20,20,20);
                    tag.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
                    tag.setText(Objects.requireNonNull(pref.getValue()).toString());
                    preferencesTage.addView(tag);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return root;
    }

    private void setupMissionsList(ListView missionsList) {
        MissionsAdapter adapter;
        ArrayList missions = new ArrayList<Mission>();
        missions.add(new Mission(1,
                "ללוות את סבתא סוזי",
                "19/2/2022 16:30",
                "יש ללוות את סבתא סוזי מביתה עד לסופר וחזרה",
                "מרכז",
                "פתח תקווה",
                false,
                "",
                1));
        missions.add(new Mission(2,
                "אריזת מזון",
                "20/3/2022 12:30",
                "אריזות מזון לקראת חג הפסח למשפחות נזקקות",
                "מרכז",
                "תל אביב",
                false,
                "",
                10));
        missions.add(new Mission(3,
                "תמיכה בנוער באוכלוסיות מוחלשות",
                "22/3/2022 18:00",
                "נערים שזקוק לעזרה שלכם בהכנת שיעורי בית בשעות הערב",
                "צפון",
                "עכו",
                false,
                "",
                10));

        adapter = new MissionsAdapter(getContext(), missions);

        missionsList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}