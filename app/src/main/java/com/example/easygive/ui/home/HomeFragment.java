package com.example.easygive.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easygive.R;
import com.example.easygive.databinding.FragmentHomeBinding;
import com.example.easygive.models.Mission;
import com.example.easygive.models.MissionsAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setupMissionsList((ListView) root.findViewById(R.id.missions_lst));

        return root;
    }

    private void setupMissionsList(ListView missionsList) {
        MissionsAdapter adapter;
        ArrayList missions = new ArrayList<Mission>();
        missions.add(new Mission(1, "name1", "date", "desc", "area", "city", false, "ORGAN", 21));
        missions.add(new Mission(1, "name12", "date2", "desc2", "area2", "city2", false, "ORGAN2", 21));

        adapter = new MissionsAdapter(getContext(), missions);

        missionsList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}